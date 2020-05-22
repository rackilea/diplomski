private static final ExecutorService executor = Executors.newFixedThreadPool(N);
// ...
while (isOnJob) {
    List<JobTask> tasks = getJobTasks();
    if (!tasks.isEmpty()) {
        List<Future<?>> futures = new ArrayList<Future<?>>();
        for (final JobTask task : tasks) {
                Future<?> future = executor.submit(new Runnable() {    
                        @Override
                        public void run() {
                                task.doWork();
                        }
                });
                futures.add(future);
        }
        // you no longer need to use await
        for (Future<?> fut : futures) {
          fut.get();
        }
    }
}