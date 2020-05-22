// SETUP
Runnable notifier = new Runnable() {
    public void run() {
        System.out.print(".");
    }
};

ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

// IN YOUR WORK THREAD
scheduler.scheduleAtFixedRate(notifier, 1, 1, TimeUnit.SECONDS);
// DO YOUR WORK
schedule.shutdownNow();