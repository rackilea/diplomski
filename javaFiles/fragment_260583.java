@Bean
public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory =
            new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setDestinationResolver(destinationResolver());
    factory.setConcurrency("3-10");
    factory.setClientID("brokerClientId");
    factory.setSubscriptionDurable(true);
    return factory;
}