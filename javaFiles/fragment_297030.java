protected LinkedBlockingQueue<Message> messages = new LinkedBlockingQueue<>();
 public void receiveMessages() {
    try {
        Message message = new Message();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            long deliveryTag = delivery.getEnvelope().getDeliveryTag();
            String response = new String(delivery.getBody(), "UTF-8");
            if (response != null) {
                message.setId(NUID.nextGlobal());
                message.setPayload(response);
                message.setDeliveryTag(deliveryTag);
                messages.add(message);
                logger.info("Message received: ", message.getPayload());
            };
        channel.basicConsume(queueName, false, deliverCallback, consumerTag -> { });
    } catch (Exception e) {
        logger.error("Exception while getting messages from Rabbit ", e);
    }
}