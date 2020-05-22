import android.app.Activity;
   import android.graphics.Color;
   import android.os.Bundle;

 public class MainActivity extends Activity {
     LineView lineview;
     Button button;

     @Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lineview = (LineView)findViewById (R.id.lineView1);
    button = (Button)findViewById(R.id.button1); 
    lineview.setVisibility(View.INVISIBLE);
    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            lineview.setVisibility(View.VISIBLE);
        }
    });


  }
}