public class GenericJsonSplitterApp {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "app1");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, MapSerdes.class);

        final StreamsBuilder builder = new StreamsBuilder();
        KStream<String, Map<String, String>> source = builder.stream("input");
        KStream<String, Map<String, String>> output = source
                .flatMapValues(map ->
                        Arrays.stream(map.get("name")
                                .split(","))
                                .map(name -> {
                                    HashMap<String, String> splittedMap = new HashMap<>(map);
                                    splittedMap.put("name", name);
                                    return splittedMap;
                                })
                                .collect(Collectors.toList()));
        output.to("output");

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}