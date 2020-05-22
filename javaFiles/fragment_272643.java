package com.example.thoma.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
     Button thomasButton = (Button)findViewById(R.id.btn_Change);

     TextView thomasText = (TextView) findViewById(R.id.txt_View);

     thomasButton.setOnLongClickListener(new View.OnLongClickListener() {
        public boolean onLongClick(View v) {
            thomasText.setText("Artificial");

            // it will return false if long click wasnt long enough
            // and normal click will be called

            return true;
        }
    });

}

public void displayMessage(View v){
    TextView thomasText = (TextView)findViewById(R.id.txt_View);
    thomasText.setText(R.string.rsc_Text2);
}


}