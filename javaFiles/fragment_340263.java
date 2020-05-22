ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
RetryExecutor executor = new AsyncRetryExecutor(scheduler).
    retryOn(SocketException.class).
    withExponentialBackoff(500, 2).     //500ms times 2 after each retry
    withMaxDelay(10_000).               //10 seconds
    withUniformJitter().                //add between +/- 100 ms randomly
    withMaxRetries(20);

final CompletableFuture<Socket> future = executor.getWithRetry(() ->
        new Socket("localhost", 8080)
);

future.thenAccept(socket ->
        System.out.println("Connected! " + socket)
);