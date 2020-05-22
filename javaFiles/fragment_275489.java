ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
Runnable r = new Runnable() {
    @Override
    public void run() {
        sendData();
    }
};
ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(r, 0, 15, TimeUnit.SECONDS);

//when you want to cancel the scheduled task
future.cancel(true);

//and before you leave your program, don't forget to call:
scheduler.shutdown();