public void testBH3() throws ExecutionException, InterruptedException {
    Publisher<String> stringPublisher = Source
        .from(Lists.newArrayList("Hello", "World", "!"))
        .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), materializer);

    Source<String, NotUsed> allMessages = Source
        .fromPublisher(stringPublisher)
        .toMat(BroadcastHub.of(String.class, 256), Keep.right())
        .run(materializer);

    allMessages
        .runForeach(System.out::println, materializer)
        .toCompletableFuture()
        .get();
}

public void repeat() throws ExecutionException, InterruptedException {
    for (int i = 0; i < 100; i++) {
        testBH3();
        System.out.println("------");
    }
}