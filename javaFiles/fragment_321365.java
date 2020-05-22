public boolean test() throws Exception {
    int a = 5;
    int b = 3;

    CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    });
    return future.get();
}