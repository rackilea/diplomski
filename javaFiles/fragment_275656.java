public class MainActivity extends Activity implements OnGestureListener {
    private static final String FORMAT = "%02d:%02d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


    }


    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {
        new CountDownTimer(5000, 10) {
            public void onTick(long millisUntilFinished) {
                text.setText("" + String.format("%02d:%03d",
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toMillis(millisUntilFinished) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished))
                ));

                if (animationRunning) {
                    cancel();
                }
            }

            public void onFinish() {
                text.setText("done!");
            }
        }.start();
    }
}