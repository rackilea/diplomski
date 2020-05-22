package com.example.android.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

final TextView mShowCounter;
final Button button;
private int mCount = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mShowCounter = (TextView) findViewById(R.id.text_view_counter);
    button = (Button) findViewById(R.id.toast_button);
}


public void showToast(View view) {
    Toast toast = Toast.makeText(this, 
R.string.toast_popup,Toast.LENGTH_LONG);
    toast.show();
}

public void counterUp(View view) {
    mCount++;
    if(mShowCounter != null) {
        mShowCounter.setText(Integer.toString(mCount));
    }
}
}