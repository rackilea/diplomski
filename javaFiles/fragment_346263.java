ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor(); 
ses.scheduleAtFixedRate(new Runnable() {
    public void run() {
        // do something.
    }
}, 0, 2, TimeUnit.SECONDS);