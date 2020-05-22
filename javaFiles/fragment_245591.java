ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

ses.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        // code to run
    }
}, 0, 1, TimeUnit.SECONDS);

// when finished
ses.shutdown();