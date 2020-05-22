@Bean
public ConsumerFactory<?, ?> kafkaConsumerFactory(KafkaProperties properties) {
    Map<String, Object> consumerProps = properties.buildConsumerProperties();
    consumerProps.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 5_000);
    return new DefaultKafkaConsumerFactory<Object, Object>(consumerProps);
}