ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

Runnable task = new Runnable() {
    public void run() {
        // Do your first concurrent work here
    }
};

executorService.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);