CountDownTimer countDownTimer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    countDownTimer = new CountDownTimer(2000, 1000) {
        @Override
        public void onFinish() {
            //what you want to do after CountDownTimer is done
            countDownTimer.start(); //start again
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

    };

    countDownTimer.start();
}