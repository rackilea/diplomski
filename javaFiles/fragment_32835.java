private Handler mStatusHandler = new Handler();
 private Runnable mStatusRunnable;
 private void checkStatus() {
        mStatusRunnable = new Runnable() {
        @Override
        public void run() {
            // Hear right your on button click code.
            checkStatus();
        }

    };
    mStatusHandler.postDelayed(mStatusRunnable, 2000);
}