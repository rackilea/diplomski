@Configuration
@EnableJms
public class FooJmsConfig {

@Bean
public ActiveMQConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(BROKER_URL);
    connectionFactory.setPassword(BROKER_USERNAME);
    connectionFactory.setUserName(BROKER_PASSWORD);
    connectionFactory.setUseCompression(true);

    connectionFactory.setConnectionIDPrefix("DRR");
    connectionFactory.setUseAsyncSend(true);
    return connectionFactory;
}

@Bean(name= "foo1")
public DefaultJmsListenerContainerFactory foo1() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setConcurrency("1-1");
    factory.setPubSubDomain(true);
    factory.setSubscriptionDurable(true);

    connectionFactory.setClientID("FOO_1");
    return factory;
}

 @Bean(name= "foo2")
public DefaultJmsListenerContainerFactory foo2() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setConcurrency("1-1");
    factory.setPubSubDomain(true);
    factory.setSubscriptionDurable(true);

    connectionFactory.setClientID("FOO_1");
    return factory;
}

}