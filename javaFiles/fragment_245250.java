private final int DELAY  = 4000;

    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {

        @Override
        public void run() {

             runOnUiThread(new Runnable() {

                  @Override
                   public void run() {

                   Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                 SplashActivity.this.startActivity(mainIntent);
                 SplashActivity.this.finish();
            }

            timer.cancel();

           }
    }, DELAY);