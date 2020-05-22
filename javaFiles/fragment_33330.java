public class Main {
    public static void main(String[] args) {
        StreamsBuilder builder = new StreamsBuilder();
        Logger logger = LoggerFactory.getLogger(Main.class);

        builder.table("inputTopic", Materialized.as(Stores.inMemoryKeyValueStore("myStore")).withCachingEnabled())
                .toStream()
                .foreach((k, v) -> logger.info("Result: {} - {}", k, v));

        new KafkaStreams(builder.build(), getProperties()).start();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(APPLICATION_ID_CONFIG, "testApp");
        properties.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(COMMIT_INTERVAL_MS_CONFIG, 10000);
        properties.put(CACHE_MAX_BYTES_BUFFERING_CONFIG, 10 * 1024 * 1024L);
        properties.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        return properties;
    }
}