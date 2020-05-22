private Timer timer;
private Handler handler;
@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    handler = new Handler();

        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    YourActivity.this.setContentView(R.layout.mainmenu);
                }
            });

        }
    };
    timer.schedule(timerTask, 5000);
}