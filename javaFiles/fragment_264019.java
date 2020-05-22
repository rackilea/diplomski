List<Callable<Result>> tasks = new ArrayList<>();
for (final Object job: jobs) {
    final Callable<Result> task = new Callable<Result>() {
            @Override
            public Result call() throws Exception {
                // Do job here
                return result;
            }
        };
    tasks.add(task);
}
final numOfThreads = 20; 
final ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
try {
    executor.invokeAll(tasks);
} finally {
    executor.shutdownNow();
}