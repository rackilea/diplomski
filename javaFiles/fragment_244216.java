CompletableFuture<HandelerFuture[]> dispatchBoth(String... urls) {
    ArrayList<HandelerFuture> futures = new ArrayList<>(); // all results
    for (String url : urls) {
        HandelerFuture future = new HandelerFuture();
        futures.add(future);
        WebClient client = WebClient.create(vertx);
        client.get(8081, "localhost", url)
              .send(future);
    }
    CompletableFuture all = new CompletableFuture();
    HandelerFuture[] array = futures.toArray(new HandelerFuture[0]);
    CompletableFuture.allOf(array)
            .thenRunAsync(() -> all.complete(array));
    return all;
}