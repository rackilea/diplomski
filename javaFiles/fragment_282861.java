@Value("${bootstrap.servers}")
private String bootstrapServers;
@Value("${group.id}")
private String groupId;
@Value("${enable.auto.commit}")
private String enableAutoCommit;
@Value("${auto.commit.interval.ms}")
private String autoCommit;
@Value("${key.deserializer}")
private String keyDeserializer;
@Value("${value.deserializer}")
private String valueDeserializer;
@Value("${session.timeout.ms}")
private String sessionTimeout;
@Value("${request.timeout.ms}")
private String requestTimeout;

@Bean
 public KafkaProducer<String, String> eventProducer() {

    try {
        Properties properties = new Properties();
        properties.put("bootstrap.servers",bootstrapServers+"9092");
        properties.put("group.id",groupId);
        properties.put("enable.auto.commit",enableAutoCommit);
        properties.put("auto.commit.interval.ms",autoCommit);
        properties.put("key.deserializer",keyDeserializer);
        properties.put("value.deserializer",valueDeserializer);
        properties.put("session.timeout.ms",sessionTimeout);
        properties.put("request.timeout.ms",requestTimeout);

        return new KafkaProducer<String, String>(properties);
    } catch (final IOException exception) {
        LOG.error("Error loading Kafka producer properties", exception);
    }
    // Avoid return null in your code instead throw an exception
    throw new IllegalAccessException("Error loading Kafka producer properties");
}