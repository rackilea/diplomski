Future<Boolean> future = threadPool.submit(task);

try {
    boolean needToBeScheduled = future.get();

    if (needToBeScheduled) {
        threadPool.schedule(task, delay, TimeUnit.MINUTES);
    }
} catch (InterruptedException | ExecutionException e) {
    e.printStackTrace();
}