import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sample extends Activity {

// Declare a variable to hold count down timer's paused status
private boolean isPaused = false;
// Declare a variable to hold count down timer's paused status
private boolean isCanceled = false;

// Declare a variable to hold CountDownTimer remaining time
private long timeRemaining = 0;
CountDownTimer timer;
long millisInFuture = 4000; // 30 seconds
long countDownInterval = 1000; // 1 second
TextView tView;
Button btnStart;
Button btnPause;
Button btnResume;
Button btnCancel;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get reference of the XML layout's widgets
    tView = (TextView) findViewById(R.id.tv);
    btnStart = (Button) findViewById(R.id.btn_start);

    // Set a Click Listener for start button
    btnStart.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            timercall();

            // Disable the start and pause button
            btnStart.setEnabled(false);

            // Initialize a new CountDownTimer instance

        }
    });

    // Set a Click Listener for pause button

    // Set a Click Listener for resume button

}

private void timercall() {
    // TODO Auto-generated method stub
    btnStart.setEnabled(false);
    timer = new CountDownTimer(millisInFuture, countDownInterval) {
        public void onTick(long millisUntilFinished) {
            // do something in every tick
            if (isPaused || isCanceled) {
                // If the user request to cancel or paused the
                // CountDownTimer we will cancel the current
                // instance
                cancel();
            } else {
                // Display the remaining seconds to app interface
                // 1 second = 1000 milliseconds
                tView.setText("" + millisUntilFinished / 1000);
                // Put count down timer remaining time in a variable
                timeRemaining = millisUntilFinished;
            }
        }

        public void onFinish() {
            // Do something when count down finished
            tView.setText("Activated");
            btnStart.setText("Active");
            btnStart.setEnabled(true);
            btnStart.setClickable(true);
            // Enable the start button
            btnStart.setEnabled(true);
            // Disable the pause, resume and cancel button
            btnStart.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getApplicationContext(), "next page",
                            Toast.LENGTH_SHORT).show();
                }
            });

        }
    }.start();
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    // getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    // noinspection SimplifiableIfStatement
    /*
     * if (id == R.id.action_settings) { return true; }
     */

    return super.onOptionsItemSelected(item);
}
}