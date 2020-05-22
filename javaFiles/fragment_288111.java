import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

TextView tv1;
TextView tv2;
TextView tv3;

Button b1;
Button b2;
Button b3;

int time1 = 0;
int time2 = 0;
int time3 = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tv1 = (TextView)findViewById(R.id.tv1);
    tv2 = (TextView)findViewById(R.id.tv2);
    tv3 = (TextView)findViewById(R.id.tv3);

    b1    = (Button)findViewById(R.id.b1);
    b2    = (Button)findViewById(R.id.b2);
    b3    = (Button)findViewById(R.id.b3);
}

public void startFirstTimer(View v){
    time1 = 0;

    final Handler h = new Handler();
    final int DELAY = 1000; //milliseconds

    h.postDelayed(new Runnable(){
        public void run(){
            time1++;
            tv1.setText(Integer.toString(time1));
            h.postDelayed(this, DELAY);
        }
    }, DELAY);
}
public void startSecondTimer(View view){
    time2 = 0;

    final Handler h = new Handler();
    final int DELAY = 1000; //milliseconds

    h.postDelayed(new Runnable(){
        public void run(){
            time2++;
            tv2.setText(Integer.toString(time2));
            h.postDelayed(this, DELAY);
        }
    }, DELAY);
}
public void startThirdTimer(View view){
    time3 = 0;

    final Handler h = new Handler();
    final int DELAY = 1000; //milliseconds

    h.postDelayed(new Runnable(){
        public void run(){
            time3++;
            tv3.setText(Integer.toString(time3));
            h.postDelayed(this, DELAY);
        }
    }, DELAY);
}
}