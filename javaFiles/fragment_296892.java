Executor executor = Executors.newSingleThreadExecutor();
CompletableFuture<Object> cf = new CompletableFuture<>();
cf.whenCompleteAsync((t, throwable) -> {
    System.out.println(Thread.currentThread().toString());
}, executor);
cf.complete(new Object());