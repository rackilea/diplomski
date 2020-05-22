ExecutorService exec = Executors.newFixedThreadPool(10);

<T> T doInConstantTime(Callable<T> task, long millis, T defaultResponse) {
    Future<T> future = exec.submit(task);
    Thread.sleep(millis);
    if (future.isDone()) {
        return future.get();
    } else {
        future.cancel(false); // or true? 
        return defaultResponse;
    }
}