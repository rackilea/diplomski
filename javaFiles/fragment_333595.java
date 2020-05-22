private long waitForMillis;

private AtomicInteger taskNo;

private ScheduledExecutorService executorService;

public RepeatedCallScheduler(long waitForMillis) {
    this.waitForMillis = waitForMillis;
    this.taskNo = new AtomicInteger();
    executorService = Executors.newScheduledThreadPool(4); // Whatever you need
}

public void run(Runnable runnable) {

    int no = taskNo.incrementAndGet();

        executorService.schedule(() -> {
            // Check if the task should be executed
            if (no == taskNo.get()) {
                // Logic.. 
            }
        }, waitForMillis, TimeUnit.MILLISECONDS);
}