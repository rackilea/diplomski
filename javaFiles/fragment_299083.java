protected CamelContext createCamelContext() throws Exception {
    CamelContext camelContext = super.createCamelContext();
    String url = "vm://test-broker?broker.persistent=false&broker.useJmx=false";
    ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
    camelContext.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
    return camelContext;
}