@Bean
public StreamsBuilderFactoryBeanCustomizer streamsBuilderFactoryBeanCustomizer() {
    return factoryBean -> {
        factoryBean.setKafkaStreamsCustomizer(new KafkaStreamsCustomizer() {
            @Override
            public void customize(KafkaStreams kafkaStreams) {
                kafkaStreams.setGlobalStateRestoreListener(...);
            }
        });
    };
}