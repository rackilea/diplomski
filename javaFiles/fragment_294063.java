queueToConsumer.forEach((queueName, consumer) -> {
    channel.basicConsume(queueName, true, new DefaultConsumer() {
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
            consumer.accept(body);
        }
    });
});