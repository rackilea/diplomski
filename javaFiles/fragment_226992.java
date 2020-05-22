package com.example.goldennuggetnlapp;

import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }

    public void myClickHandler(View v){
        startActivity(new Intent(this, InformationActivity.class));

     }
    // more code goes here
}