final DataStream<Tuple2<String, Integer>> counts = env
        .socketTextStream("localhost", 9999)
        .flatMap(new Splitter())
        .groupBy(0)
        .window(Time.of(5, TimeUnit.SECONDS)).sum(1)
        .flatten();