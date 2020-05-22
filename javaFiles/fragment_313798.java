private static CompletableFuture<Collection<Info>> invoke() {
    return CompletableFuture.supplyAsync(() -> {
        //call
        return httpsService.requestAccessInfo(requestInfo);;
    }, executorService);
}