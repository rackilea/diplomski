SourceQueueWithComplete<Object> componentA_outPort1 = 
    Source.<Object>queue(100, OverflowStrategy.backpressure()).async()
        .to(Sink.foreach(str -> System.out.println(str)))
        .run(materializer);

for (int i=1; i<100000; i++) {
  componentA_outPort1.offer("Akka rocks: " + i).toCompletableFuture().join();
}