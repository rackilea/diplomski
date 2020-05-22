private Runnable ssdpTimerTask = new Runnable() {
        @Override
        public void run() {
            startStationSearch();
            Log.d(TAG,"Running SSDP search - iteration: "+ssdpIteration);
            ssdpIteration++;
            mHandler.postDelayed(ssdpTimerTask,5000);
        }
    };