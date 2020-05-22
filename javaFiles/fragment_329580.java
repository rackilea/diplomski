@RabbitListener(bindings = @QueueBinding(value = @Queue(Queues.RENDER_NAME),
        exchange = @Exchange(value = Exchanges.EXC_RENDER_NAME, type = "topic"),
        key = "render.#")
)
public void onMessage(Message message, Channel channel,
                      @Header(AmqpHeaders.DELIVERY_TAG) long tag
) {
    RenderQueueObject queueObject = parseRender(message, RenderQueueObject.class);
    if (message.getMessageProperties().isRedelivered()) {
        log.info("Message Redelivered, try also");
        try {
            channel.basicAck(tag, false);
            MessageConverter messageConverter = rabbitTemplate.getMessageConverter();
            String valueAsString = parseBody(message);
            Message copyMessage = messageConverter.toMessage(valueAsString, new MessageProperties());
            rabbitTemplate.convertAndSend(
                    message.getMessageProperties().getReceivedRoutingKey(),
                    copyMessage);
            return;
        } catch (IOException e) {
            log.info("basicAck exception");
        }
    }
    log.info("message not redelievered");
    String routingKey = parseRoutingKey(message);
    log.debug(String.format("Event %s", routingKey));
    handleMessage(queueObject);
}