package com.dave.kelley;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class TestRadioActivity extends Activity {

    int timeSetting = 0;
    RadioButton radio0;
    RadioButton radio1;
    RadioButton radio2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(listener);
        radio0 = (RadioButton) findViewById(R.id.radio0);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
    }

    public OnClickListener listener = new OnClickListener() {
        public void onClick(View v) {
            if (timeSetting == 0) {
                radio0.setChecked(true);
                radio1.setChecked(false);radio2.setChecked(false);
            }
            if (timeSetting == 1) {
                radio1.setChecked(true);
                radio0.setChecked(false);radio2.setChecked(false);
            }
            if (timeSetting == 2) {
                radio2.setChecked(true);
                radio0.setChecked(false);radio1.setChecked(false);
            }
            timeSetting++;
            if(timeSetting == 3 || timeSetting > 3) {
                timeSetting = 0;
            }
        }
    };
}