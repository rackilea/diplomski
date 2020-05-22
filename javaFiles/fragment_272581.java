public class RetriableTask
{
    protected static final int MAX_RETRIES = 10;
    protected int retries = 0;
    protected int n = 0;
    protected CompletableFuture<Integer> future = new CompletableFuture<Integer>();

    public RetriableTask(int number) {
        n = number;
    }

    public CompletableFuture<Integer> executeAsync() {
        // Create a failure within variable timeout
        Duration timeoutInMilliseconds = Duration.ofMillis(1*(int)Math.pow(2, retries));
        CompletableFuture<Integer> timeoutFuture = Utils.failAfter(timeoutInMilliseconds);

        // Create a dummy future and complete only if (n > 5 && retries > 5) so we can test for both completion and timeouts. 
        // In real application this should be a real future
        final CompletableFuture<Integer> taskFuture = new CompletableFuture<>();
        if (n > 5 && retries > 5)
            taskFuture.complete(retries * n);

        // Attach the failure future to the task future, and perform a check on completion
        taskFuture.applyToEither(timeoutFuture, Function.identity())
            .whenCompleteAsync((result, exception) -> {
                if (exception == null) {
                    future.complete(result);
                } else {
                    retries++;
                    if (retries >= MAX_RETRIES) {
                        future.completeExceptionally(exception);
                    } else {
                        executeAsync();
                    }
                }
            });

        // Return the future    
        return future;
    }
}