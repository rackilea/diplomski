private Handler mHandler = new Handler();
    int ms=2000; //2secs.
    Define a Runnable:

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            // get random number here

        // You could do this call if you wanted it to be periodic:

    ms=ms-20; //20ms faster
            mHandler.postDelayed(this, ms);

            }
        };

    mHandler.postDelayed(mUpdateTimeTask, 100);