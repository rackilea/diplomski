ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Runnable r = new Runnable() {

        @Override
        public void run() {
            invokeWebService();
        }
    };

    scheduler.scheduleAtFixedRate(r, 0, 30, TimeUnit.SECONDS);