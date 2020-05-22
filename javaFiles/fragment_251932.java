private float imageAplha = 1f;
private boolean imageStatus = false;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    splashScreenUseAsyncTask();
}


// Show splash screen until network load data complete.
private void splashScreenUseAsyncTask()
{
    // Create a AsyncTask object.
    final RetrieveDateTask retrieveDateTask = new RetrieveDateTask();
    retrieveDateTask.execute("", "", "");
    // Get splash image view object.
    final ImageView splashImageView = (ImageView) findViewById(R.id.logo_id);
    final TextView tv_hour = (TextView) findViewById(R.id.tv_hour);
    final TextView tv_minute = (TextView) findViewById(R.id.tv_minute);
    final TextView tv_second = (TextView) findViewById(R.id.tv_second);

    // Create a count down timer object.It will count down every 0.1 seconds and last for milliSeconds milliseconds..
    final int time= 3600000*5;
    CountDownTimer countDownTimer = new CountDownTimer(time, 1000) {
        @Override
        public void onTick(long l) {


            long Days = l / (24 * 60 * 60 * 1000);
            long Hours = l / (60 * 60 * 1000) % 24;
            long Minutes = l / (60 * 1000) % 60;
            long Seconds = l / 1000 % 60;
            //
          //  tv_days.setText(String.format("%02d", Days));
            tv_hour.setText(String.format("%02d", Hours));
            tv_minute.setText(String.format("%02d", Minutes));
            tv_second.setText(String.format("%02d", Seconds));

            splashImageView.setAlpha(imageAplha);


            if(imageStatus){
                imageAplha += 1;
                if(imageAplha >= 1)
                {
                   // imageAplha-= 0.5;
                    imageStatus =  false;
                }
            }else{
                imageAplha -= 1;
                if(imageAplha <= 0)
                {

                    imageStatus =  true;
                }
            }

        }

        @Override
        public void onFinish() {
            // When count down complete, set the image to invisible.
            imageAplha = 0;
            splashImageView.setAlpha(imageAplha);

            // If AsyncTask is not complete, restart the counter to count again.
            if(!retrieveDateTask.isAsyncTaskComplete()) {
                this.start();
            }
        }
    };
    // Start the count down timer.
    countDownTimer.start();
}

// This is the async task class that get data from network.
private class RetrieveDateTask extends AsyncTask<String, String, String> {

    // Indicate whether AsyncTask complete or not.
    private boolean asyncTaskComplete = false;

    public boolean isAsyncTaskComplete() {
        return asyncTaskComplete;
    }

    public void setAsyncTaskComplete(boolean asyncTaskComplete) {
        this.asyncTaskComplete = asyncTaskComplete;
    }

    // This method will be called before AsyncTask run.
    @Override
    protected void onPreExecute() {
        this.asyncTaskComplete = false;
    }

    // This method will be called when AsyncTask run.
    @Override
    protected String doInBackground(String... strings) {
        try {
            // Simulate a network operation which will last for 10 seconds.
            Thread currTread = Thread.currentThread();
            for (int i = 0; i < 18000000; i++) {
                currTread.sleep(1000);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally {
            return null;
        }
    }

    // This method will be called after AsyncTask run.
    @Override
    protected void onPostExecute(String s) {
        // Start SplashScreenMainActivity.
        Intent mainIntent = new Intent(splash_screen .this,
                MainActvity.class);
        splash_screen.this.startActivity(mainIntent);
        // Close SplashScreenActivity.
        splash_screen.this.finish();
        this.asyncTaskComplete = true;
    }
}