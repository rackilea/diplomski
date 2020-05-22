public static <T> CompletableFuture<T> foo(Callable<CompletableFuture<T>> callable) {
    try {
        return callable.call();
    } catch (Exception ex) {
        return CompletableFuture.failedFuture(ex);
    }
}