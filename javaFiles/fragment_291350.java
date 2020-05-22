private Handler mHandler = new Handler();
private int mTrials = 0;
private Runnable mPeriodicTask = new Runnable() {
    public void run() {
        // Do the check

        mTrials += 1;
        if (mTrials == /* timeout number */) {
            // timeout
        } else {
            mHandler.postDelayed(this, 2500);
        }
    }
}