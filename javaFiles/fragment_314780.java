handler = new Handler();
    runnable = new Runnable() {
        public void run() {
           location = getLocation();
           handler.postDelayed(runnable, UPDATE_CYCLE_PERIOD);
        }
    };