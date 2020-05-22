public class MainActivity extends Activity {

    Button incrementTime, startTime;
    public TextView timedisplay;
    long millisInFuture = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementTime = (Button) findViewById(R.id.button2);
        startTime = (Button) findViewById(R.id.button3);
        timedisplay = (TextView) findViewById(R.id.mycounter);

        resetText();

        incrementTime.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                millisInFuture += 1000;
                resetText();
            }
        });

        startTime.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
                CountDownTimer wavetimer = new myTimer(millisInFuture + 3000, 1000).start();
                // ^ add 3 seconds.
            }
        });}

    protected void resetText() {
        timedisplay.setText("Time Left: " + millisInFuture / 1000);
    }

    public class myTimer extends CountDownTimer  {

        private long millisActual;

        public myTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            millisActual = millisInFuture - 3000;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //v start showing the tick after 3 seconds.
            if (millisUntilFinished <= millisActual) {
                timedisplay.setText("Time Left: " + millisUntilFinished / 1000);                
            }
        }

        @Override
        public void onFinish() {
            timedisplay.setText("Countdown Finished");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}