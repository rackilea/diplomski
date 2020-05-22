package com.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Demo2Activity extends Activity {
    private Button button;
    private EditText editText;
    private TextView textView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textText);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("Electronics")) {
                    textView.setText("found");
                }

            }
        });

    }
}