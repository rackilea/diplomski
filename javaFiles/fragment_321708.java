import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private CountDownTimer mCountDownTimer;

    private static final long INTERVAL = 1000L;
    private long timeRemaining = 60000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.text_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mCountDownTimer = new CountDownTimer(timeRemaining, INTERVAL) {
            @Override
            public void onTick(long l) {
                mTextView.setText(String.format(Locale.getDefault(), "%d sec.", l / 1000L));
                timeRemaining = l;
            }

            @Override
            public void onFinish() {
                mTextView.setText("Done.");
            }
        };
        mCountDownTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCountDownTimer.cancel();
    }
}