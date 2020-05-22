private Runnable mUpdateTimeTask = new Runnable() {
    public void run() {

        // Get the difference in ms
        long millis = SystemClock.uptimeMillis() - mStartTime;

        // Format to hours/minutes/seconds
        mTimeInSec = (int) (millis / 1000);

        // Do your thing

        // Update at the next second
        mHandler.postAtTime(this, mStartTime + ((mTimeInSec + 1) * 1000));
    }
};