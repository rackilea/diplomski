package com.example.rick2.rekentuin_native;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OefenenActivity extends AppCompatActivity {

int index = 0;
int intArray[] = new int[]{1,2,3,4,5,6,7,8,9,10};
TextView tv2;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_oefenen);

    String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
    TextView tv1 = findViewById(R.id.textView6);
    tv1.setText(sessionId);



    tv2 = findViewById(R.id.textView5);
    tv2.setText(Integer.toString(intArray[index]));
}

public void CheckAns(View view) {
        EditText edit = findViewById(R.id.editText4);
        Integer result = Integer.parseInt(edit.getText().toString());
        int number1 = Integer.parseInt(sessionId);

        if (result == intArray[index] + number1) {
            if (index < 10) {
                index++;
                tv2.setText(Integer.toString(intArray[index]));
            }
        }
    }

}