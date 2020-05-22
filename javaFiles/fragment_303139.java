package com.ian.counter;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class CounterActivity extends Activity {
    /** Called when the activity is first created. */
    TextView textView1;
    int count = 0;
    @Override  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView1 = (TextView) this.findViewById(R.id.textView1);
    }

    public void Count(){
        count ++;
        textView1.setText(Integer.toString(count));
    }
}