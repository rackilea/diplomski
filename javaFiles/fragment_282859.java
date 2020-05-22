@Bean
 public KafkaProducer<String, String> eventProducer() {

    try {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","XXXX:9092");
        properties.put("group.id","consumers");
        properties.put("enable.auto.commit","true");
        properties.put("auto.commit.interval.ms","1000");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("session.timeout.ms","300000");
        properties.put("request.timeout.ms","305000");

        return new KafkaProducer<String, String>(properties);
    } catch (final IOException exception) {
        LOG.error("Error loading Kafka producer properties", exception);
    }
    // Avoid return null in your code instead throw an exception
    throw new IllegalAccessException("Error loading Kafka producer properties");
}