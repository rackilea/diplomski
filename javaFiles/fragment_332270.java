public static void execute(List<Callable<Boolean>> threadList) throws Exception {
    CompletableFuture<?> tail = CompletableFuture.allOf(
        threadList.stream().skip(1)
            .map(c -> callAsync(c, myThreadPoolExecutor))
            .toArray(CompletableFuture<?>[]::new)),
        head = callAsync(threadList.get(0), Runnable::run);
    try {
        head.get();
        tail.get();
    }
    catch(Exception e) {
        //do some calculations here and then throw exception
        throw new Exception(e.getMessage(), e);
    }
}