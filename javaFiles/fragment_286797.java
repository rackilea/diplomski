KStream<String, Model> stream = builder.stream(
    Serdes.String(),
    specificAvroSerde,
    "not-filtered-topic"
);
KStream[] splitStreams = stream.branch(
    (key, value) -> new Processor().test(key,value),
    (key, value) -> true
);
splitStreams[0].to(Serdes.String(), specificAvroSerde, "good-topic");
splitStreams[1].to(Serdes.String(), specificAvroSerde, "bad-topic");