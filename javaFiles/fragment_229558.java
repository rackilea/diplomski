private <T> CompletableFuture<T> timeoutAfter(ScheduledExecutorService es,
    long timeout, TimeUnit unit, CompletableFuture<T> f, T value) {

    es.schedule(() -> f.complete(value), timeout, unit);
    return f;
}