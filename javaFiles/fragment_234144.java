@Bean
public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
        DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    // the configurer will use PubSubDomain from application.properties if defined or false if not
    //so setting it on the factory level need to be set after this
    configurer.configure(factory, connectionFactory);
    factory.setPubSubDomain(true);
    return factory;
}