ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
executor.scheduleAtFixedRate(new Runnable() {
    public void run() {
       // Create your object;
    }
}, 0, 3, TimeUnit.SECONDS);