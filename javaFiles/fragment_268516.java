ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
ses.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        // do some work
    }
}, 0, x, TimeUnit.SECONDS);  // execute every x seconds