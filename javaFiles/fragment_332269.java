public static void execute(List<Callable<Boolean>> threadList) throws Exception {
    if(1 == threadList.size()) {
        threadList.get(0).call();
    }
    else {
        CompletableFuture<?> all = CompletableFuture.allOf(
            threadList.stream()
                .map(c -> callAsync(c, myThreadPoolExecutor))
                .toArray(CompletableFuture<?>[]::new));
        try {
            all.get();
        }
        catch(Exception e) {
            //do some calculations here and then throw exception
            throw new Exception(e.getMessage(), e);
        }
    }
}
public static <R> CompletableFuture<R> callAsync(Callable<R> callable, Executor e) {
    CompletableFuture<R> cf = new CompletableFuture<>();
    CompletableFuture.runAsync(() -> {
        try { cf.complete(callable.call()); }
        catch(Throwable ex) { cf.completeExceptionally(ex); }
    }, e);
    return cf;
}