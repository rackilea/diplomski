private void send(String routingKey, String message) throws Exception { 
     Connection connection = MyConnection().getInstance();

    Channel channel = connection.createChannel();
    channel.exchangeDeclare(exchange, exchangeType);
    channel.basicPublish(exchange, routingKey, null, message.getBytes());
    log.debug(" [AMQP] Sent message with key {} : {}",routingKey, message);
    channel.close();
}