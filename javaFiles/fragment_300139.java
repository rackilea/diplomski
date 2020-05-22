public class OutboundTests {

    @Test
    public void test() throws Exception {
        KafkaProducerContext<String, String> kafkaProducerContext = new KafkaProducerContext<String, String>();
        ProducerMetadata<String, String> producerMetadata = new ProducerMetadata<String, String>("test");
        producerMetadata.setValueClassType(String.class);
        producerMetadata.setKeyClassType(String.class);
        Encoder<String> encoder = new StringEncoder<String>();
        producerMetadata.setValueEncoder(encoder);
        producerMetadata.setKeyEncoder(encoder);
        ProducerFactoryBean<String, String> producer = new ProducerFactoryBean<String, String>(producerMetadata, "localhost:9092");
        ProducerConfiguration<String, String> config = new ProducerConfiguration<String, String>(producerMetadata, producer.getObject());
        kafkaProducerContext.setProducerConfigurations(Collections.singletonMap("test", config));
        KafkaProducerMessageHandler<String, String> handler = new KafkaProducerMessageHandler<String, String>(kafkaProducerContext);
        handler.handleMessage(MessageBuilder.withPayload("foo")
                .setHeader("messagekey", "3")
                .setHeader("topic", "test")
                .build());
    }

}