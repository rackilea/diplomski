@Bean
public JmsListenerContainerFactory<?> jmsListenerContainerFactory(
        ConnectionFactory connectionFactory,
        DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    configurer.configure(factory, connectionFactory);
    factory.setTransactionManager(transactionManager());
    return factory;
}

@Bean
public PlatformTransactionManager transactionManager() {
    JmsTransactionManager transactionManager = new JmsTransactionManager();
    transactionManager.setConnectionFactory(jmsConnectionFactory());
    return transactionManager;
}

@Bean
public QueueConnectionFactory jmsConnectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:5672");
    return connectionFactory;
}