time.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            new AsyncTask().execute();
        }
    },0,1000);