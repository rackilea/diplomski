private static WebDriver currentDriver() {
    …
}
private static final ExecutorService BACKEND
    = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new PriorityBlockingQueue<>());

public static <V> CompletableFuture<V> runAsync(DriverTask<V> dt) {
    CompletableFuture<V> result = new CompletableFuture<>();
    class Job implements Runnable, Comparable<Job>,
                         CompletableFuture.AsynchronousCompletionTask {
        public void run() {
            try {
                if(!result.isDone()) result.complete(dt.call(currentDriver()));
            }
            catch(Throwable t) { result.completeExceptionally(t); }
        }
        private TaskPriority priority() { return dt.getPriority(); }
        public int compareTo(Job o) { return priority().compareTo(o.priority()); }
    }
    BACKEND.execute(new Job());
    return result;
}