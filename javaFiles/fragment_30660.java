Future<?> future = executor.submit(new customTask()));
try {
    future .get(timeout, TimeUnit.SECONDS);
} catch (InterruptedException | ExecutionException | TimeoutException e) {
    // The timeout exception is thrown when the get times out. Handle your stop logic here
}