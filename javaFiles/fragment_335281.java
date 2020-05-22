Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "app1");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, PersonSerdes.class);
    final StreamsBuilder builder = new StreamsBuilder();
    KStream<String, Person> source = builder.stream("input");
    KStream<String, Person> output = source
            .flatMapValues(person ->
                    Arrays.stream(person.getName()
                            .split(","))
                            .map(name -> new Person(name, person.getAge()))
                            .collect(Collectors.toList()));
    output.to("output");

    KafkaStreams streams = new KafkaStreams(builder.build(), props);
    streams.start();
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));