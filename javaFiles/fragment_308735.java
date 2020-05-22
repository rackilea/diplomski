@Bean
public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(AmazonSQSAsync amazonSQS) {
    SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
    factory.setAmazonSqs(amazonSQS);
    factory.setMaxNumberOfMessages(10);
    factory.setAutoStartup(true);
    factory.setWaitTimeOut(20);

    return factory;
}