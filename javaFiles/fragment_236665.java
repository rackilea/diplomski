private boolean isRunning = false;
private Handler ha = new Handler();

private void start() {
    isRunning = true;
    ha.postDelayed(new Runnable() {

        @Override
        public void run() {
            //call function

            if (isRunning) {
                ha.postDelayed(this, 10000);
            }
        }
    }, 10000);
}

private void stop() {
    isRunning = false;
    ha.removeCallbacksAndMessages(null);
}