Runnable receiveResponse = new Runnable() {
    ...
};

ExecutorService executor = Executors.newSingleThreadExecutor();
Future<?> future = executor.submit(receiveResponse);

try {
    Object result = future.get(5000, TimeUnit.MILLISECONDS);
    System.out.println("Completed successfully");
} catch (InterruptedException e) {
    ...
} catch (ExecutionException e) {
    ...
} catch (TimeoutException e) {
    System.out.println("Timed out. Cancelling the runnable...");
    future.cancel(true);
}

executor.shutdown();