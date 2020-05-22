ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
scheduler.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        System.out.println("A is running");
    }
}, 10, 5, TimeUnit.SECONDS);

Thread.sleep(20000);
scheduler.shutdown();
if (scheduler.getCompletedTaskCount() > 0) {
    System.out.println("A is done.");
}