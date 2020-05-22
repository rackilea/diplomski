Handler handler = new Handler();


    t = new Timer();
    timeTask = new TimerTask() {
        public void run() {
                handler.post(new Runnable() {
                        public void run() {
                            feedEntry.refreshFeed();
                        }
               });
        }};

        t.scheduleAtFixedRate(timeTask, 0, 1000);