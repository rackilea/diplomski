ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
executor.scheduleAtFixedRate(new Runnable() {
    public void run() {
       // Change your date object
    }
}, 0, 1, TimeUnit.SECONDS);