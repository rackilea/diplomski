public void testBH3() throws ExecutionException, InterruptedException {
    Publisher<String> stringPublisher = Source
        .from(Lists.newArrayList("Hello", "World", "!"))
        .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), materializer);

    Source<String, NotUsed> allMessages = Source
        .fromPublisher(stringPublisher)
        .throttle(1, Duration.ofSeconds(1))
        .toMat(BroadcastHub.of(String.class, 256), Keep.right())
        .run(materializer);

    allMessages
        .runForeach(System.out::println, materializer)
        .toCompletableFuture()
        .get();
}