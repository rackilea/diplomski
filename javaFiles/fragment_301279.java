public class RateLimitedTask() {
    private final Timer timer = new Timer();
    private final Semaphore semaphore;
    private final Runnable task;

    public RateLimitedTask(
            final Runnable task, 
            final int limit, 
            final int delay
    ) {
        this.task = task;
        semaphore = new Semaphore(limit);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                semaphore.release(limit);
            }
        }, delay*1000, delay*1000);
    }

    public void run() throws InterruptedException {
        semaphore.acquire();
        task.run();
    }
}