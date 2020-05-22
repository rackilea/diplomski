public static AbstractMessageListenerContainer startListening(RabbitAdmin rabbitAdmin, Queue queue, Exchange exchange, String key, MessageListener messageListener) {
    rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(key).noargs());
    SimpleMessageListenerContainer listener = new SimpleMessageListenerContainer(rabbitAdmin.getRabbitTemplate().getConnectionFactory());
    listener.addQueues(queue);
    listener.setMessageListener(messageListener);
    listener.start();

    return listener;
}