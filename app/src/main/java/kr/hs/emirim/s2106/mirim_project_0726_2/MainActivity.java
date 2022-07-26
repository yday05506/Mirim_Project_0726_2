package kr.hs.emirim.s2106.mirim_project_0726_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear1);
        Button btn1 = findViewById(R.id.btn_bg);
        btn2 = findViewById(R.id.btn_change);
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
        Button btn3 = findViewById(R.id.btn_toast);
        btn3.setOnClickListener(toastListener);
    }

    View.OnClickListener toastListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast t = Toast.makeText(MainActivity.this, "토스트 위치 변경 연습", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, Gravity.CENTER, 0);
            t.show();
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        switch (v.getId()) {
            case R.id.btn_bg:
                menu.setHeaderTitle("배경색 변경");
                inflater.inflate(R.menu.contextmenu1, menu);
                break;
            case R.id.btn_change:
                menu.setHeaderTitle("버튼 변경");
                inflater.inflate(R.menu.contextmenu2, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.item_bg_red:
                linear.setBackgroundColor(Color.RED);
                return true;
            case R.id.item_bg_black:
                linear.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.item_bg_white:
                linear.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.item_rotate:
                btn2.setRotation(50);
                return true;
            case R.id.item_zoom:
                btn2.setScaleX(2);
                return true;
            case R.id.item_return:
                btn2.setScaleX(1);
                btn2.setRotation(0);
        }
        return false;
    }
}