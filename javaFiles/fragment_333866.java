Publisher<String> stringPublisher = Source
    .from(Lists.newArrayList("Hello", "World", "!"))
    .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), materializer);

Source
    .fromPublisher(stringPublisher)
    .alsoToMat(BroadcastHub.of(String.class, 256), Keep.right())
    .mapMaterializedValue(source -> source
         .runWith(Sink.foreach(System.out::println, materializer))
    .run(materializer)
    .toCompletableFuture()
    .get();