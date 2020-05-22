package com.example.sequenceofnumbers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Button; //Include this package.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gl = findViewById(R.id.grid_layout);

        for(int i = 1; i <= 16; i++) { 
            Button btn = new Button(this);
            btn.setText(i+"");
            gl.addView(btn); // Add this line instead.
        }
    }
}