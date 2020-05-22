ScheduledExecutorService scheduler = Executors
        .newScheduledThreadPool(1);

scheduler.scheduleWithFixedDelay(new Runnable() {
    public void run() {
        System.out.println("Do something useful");
    }
}, 0, 1, TimeUnit.SECONDS);