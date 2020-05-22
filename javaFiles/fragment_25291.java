@Bean
    public ProducerFactory<Integer, String> producerFactory() {
        DefaultKafkaProducerFactory<Integer, String> producerFactory = 
                new DefaultKafkaProducerFactory<>(producerConfigs());
        producerFactory.setValueSerializer(jsonSerializer());
        return producerFactory;
    }