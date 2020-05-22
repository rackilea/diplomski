@Bean(name = "jmsOutputFlow")
public IntegrationFlow jmsOutputFlow() {
    return IntegrationFlows.from(jmsOutputChannel()).handle(Jms.outboundAdapter(jmsTemplate())
            .destination("myTopic")
    ).get();
}

@Bean(name = "jmsInputFlow")
public IntegrationFlow buildReceiverFlow() {        
    return IntegrationFlows.from(Jms.messageDrivenChannelAdapter(
            Jms.container(connectionFactory(),"myTopic")
            .pubSubDomain(true).get()) )
            .channel("jmsInputChannel").get();
}