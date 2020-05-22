@Override
protected Object doTransform(Message<?> message) throws Exception {
    Assert.notNull(message, "message must not be null");
    Object payload = message.getPayload();
    Assert.notNull(payload, "payload must not be null");
    Message<?> storedMessage = this.messageStore.addMessage(message);
    MessageBuilder<?> responseBuilder = MessageBuilder.withPayload(storedMessage.getHeaders().getId());
    // headers on the 'current' message take precedence
    responseBuilder.copyHeaders(message.getHeaders());
    return responseBuilder.build();
}