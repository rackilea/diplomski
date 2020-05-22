package com.example.helloandroid;

  import android.app.Activity;
  import android.os.Bundle;
  import android.widget.LinearLayout;
  import android.widget.TextView;
  import android.widget.LinearLayout.LayoutParams;

  public class HelloAndroid extends Activity {
TextView textview;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    LinearLayout ll= (LinearLayout) findViewById(R.id.LinearLayout01); 


      LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams
            (LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

      LinearLayout childLayout= new LinearLayout(this);
      childLayout.setOrientation(LinearLayout.VERTICAL);  
      TextView text = new TextView(this);
      text.setText("High");
      childLayout.addView(text);
      ll.addView(childLayout, lp);

}