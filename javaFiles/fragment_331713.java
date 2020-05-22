Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutting down")));

CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
    System.out.println("running...");
    String result = getJSON("https://jsonplaceholder.typicode.com/posts/1");
    System.out.println("Completed service call");
    return result;
});
cf.thenAcceptAsync(System.out::println).join();