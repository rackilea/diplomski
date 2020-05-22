@Bean
public IntegrationFlow integrationFlow(final RabbitTemplate rabbitTemplate, final AmqpHeaderMapper amqpHeaderMapper) {
    IntegrationFlows
        .from("some-input-channel")
        .handle(Amqp.outboundAdapter(rabbitTemplate)
        .headerMapper(headerMapper))
        .get()    
}

@Bean
public AmqpHeaderMapper amqpHeaderMapper() {
    final DefaultAmqpHeaderMapper headerMapper = new DefaultAmqpHeaderMapper();
    headerMapper.setRequestHeaderNames("*");
    return headerMapper;
}

@Bean
public ConnectionFactory rabbitConnectionFactory() {
   return new CachingConnectionFactory();
}

@Bean
public RabbitAdmin rabbitAdmin(final ConnectionFactory rabbitConnectionFactory) {
    final RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitConnectionFactory);
    rabbitAdmin.afterPropertiesSet();
    return rabbitAdmin;
}

@Bean
public RabbitTemplate rabbitTemplate(final ConnectionFactory rabbitConnectionFactory, final RabbitAdmin rabbitAdmin) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate();
    rabbitTemplate.setConnectionFactory(connectionFactory);

    final FanoutExchange fanoutExchange = new FanoutExchange(MY_FANOUT.getFanoutName());
    fanoutExchange.setAdminsThatShouldDeclare(rabbitAdmin);
    for (final String queueName : MY_FANOUT.getQueueNames) {
        final Queue queue = new Queue(queueName, true);
        queue.setAdminsThatShouldDeclare(rabbitAdmin);

        final Binding binding = BindingBuilder.bind(queue).to(fanoutExchange);
        binding.setAdminsThatShouldDeclare(rabbitAdmin);
    }
    rabbitTemplate.setExchange(fanoutExchange);    
}