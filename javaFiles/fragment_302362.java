@Bean
public JmsConfiguration jmsConfiguration() {
    JmsConfiguration jmsConfiguration = new JmsConfiguration();
    jmsConfiguration.setConnectionFactory(pooledConnectionFactory());
    jmsConfiguration.setConcurrentConsumers(5);
    return jmsConfiguration;
}

@Bean(name = "activemq")
public ActiveMQComponent activeMq() {
    ActiveMQComponent activeMQComponent = new ActiveMQComponent();
    activeMQComponent.setConfiguration(jmsConfiguration()); 
    return activeMQComponent;
}