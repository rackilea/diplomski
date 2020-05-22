public class MainActivity extends Activity {
    private static final int TIMER_TIME = 10000; // in millis
    private Button btnCountdown;
    private TextView tvTimeUntilFinish;
    private boolean mIsPaused = true;
    private long mMillisUntilFinish;
    private CountDownTimer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMillisUntilFinish = TIMER_TIME;

        btnCountdown = (Button) findViewById(R.id.btnCountdown);
        tvTimeUntilFinish = (TextView) findViewById(R.id.tvTimeUntilFinish);

        btnCountdown.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (mIsPaused) {
                    btnCountdown.setText("Pause");
                    initTimer();
                } else {
                    btnCountdown.setText("Play");
                    cancelTimer();
                }

                mIsPaused = !mIsPaused;
            }
        });
    }

    private void cancelTimer() {

        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

    }

    private void initTimer() {
        mTimer = new CountDownTimer(mMillisUntilFinish, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimeUntilFinish.setText("seconds remaining: " + millisUntilFinished / 1000);
                mMillisUntilFinish = millisUntilFinished;
            }

            public void onFinish() {
            }
        }.start();

    }
}