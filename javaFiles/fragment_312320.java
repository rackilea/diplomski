package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //use this to create a button in code
        MyReusableButton b = new MyReusableButton(this);
        b.setText("Hello, World");

        //use this to add margins to the button
        b.setMargins(10, 10, 10, 10);

        //add the button to the parent linear layout
        ((LinearLayout) findViewById(R.id.wrapper)).addView(b);
    }
}