verify(amqpTemplate).convertAndSend(
    eq(RabbitConfiguration.ERROR_EXCHANGE),
    eq(RabbitConfiguration.ERROR_ROUTING_KEY),
    any(Message.class),
    Mockito.any()
);