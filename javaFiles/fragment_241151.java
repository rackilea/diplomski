@Bean(name = "Exchange_B")
DirectExchange receiverExchange() {
    DirectExchange exchange = new DirectExchange("Exchange_B", true, false);
    exchange.setAdminsThatShouldDeclare(amqpAdmin());
    return exchange;
}