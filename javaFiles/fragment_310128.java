public class TimerActivity extends AppCompatActivity {

    private TextView out;
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        out = (TextView) findViewById(R.id.out);
        setText(value);

        timerUp.start();
    }

    CountDownTimer timerUp = new CountDownTimer(10000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            runnable1.run();
        }

        @Override
        public void onFinish() {
            timerDown.start();
        }
    };

    CountDownTimer timerDown = new CountDownTimer(10000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            runnable2.run();
        }

        @Override
        public void onFinish() {
            Log.e("done", "onFinish");
        }
    };

    private void setText(final int value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                out.setText(String.valueOf(value));
            }
        });
    }

    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            value += 10;
            setText(value);
        }
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            value -= 10;
            setText(value);
        }
    };
}