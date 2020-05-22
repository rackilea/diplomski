Source<String, SourceQueueWithComplete<String>> s = Source
    .queue(100, OverflowStrategy.fail());

SourceQueueWithComplete<String> queue = source
    .toMat(Sink.foreach(x -> System.out.println(x)), Keep.left())
    .run(materIalizer);

mapMapperFunction().apply(queue);