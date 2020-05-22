if(x == 1) {
    result = result.thenApplyAsync(t -> {

        return null;
    });
}
result.thenRun(() -> {
    //...
});