@Bean
public JmsListenerContainerFactory jmsTopicListenerContainerFactory(@Qualifier("activeMQConnectionFactory") ConnectionFactory connectionFactory) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setConcurrency("4-5");
    return factory;
}