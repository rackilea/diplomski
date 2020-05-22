ExecutorService exec = MoreExecutors.getExitingExecutorService(
        (ThreadPoolExecutor) Executors.newFixedThreadPool(4), 
        100_000, TimeUnit.DAYS//period after which executor will be automatically closed
                             //I assume that 100_000 days is enough to simulate infinity
);
//exec.execute(YourTask);
exec.execute(() -> {
    for (int i = 0; i < 3; i++) {
        System.out.println("daemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});