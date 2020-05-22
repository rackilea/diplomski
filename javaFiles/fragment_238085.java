@Bean
public RabbitTemplate template(ConnectionFactory rabbitConnectionFactory){
    final RabbitTemplate template = new RabbitTemplate(rabbitConnectionFactory);
    template.setReplyAddress(replyQueue().getName());
    return template;
}

@Bean
public MessageListenerContainer replyContainer(RabbitTemplate template) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(template.getConnectionFactory());
    container.setQueues(replyQueue());
    container.setMessageListener(template);
    return container;
}