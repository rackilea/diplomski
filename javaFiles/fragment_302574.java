Executor executor; // … the actual executor
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
    Executor afterTenSeconds
        = r -> ses.schedule(() -> executor.execute(r), 10, TimeUnit.SECONDS);

    Runnable primaryAction
        = () -> dndService.initateDNDRequest(transactionId, circle, category, "PREPAID");

    CompletableFuture<Void> cf = CompletableFuture.runAsync(primaryAction, executor);
    for(int i = 0; i < 3; i++) {
        cf = cf.handle((v,t) -> t == null? CompletableFuture.completedFuture(v):
                                CompletableFuture.runAsync(primaryAction, afterTenSeconds))
               .thenCompose(Function.identity());
    }