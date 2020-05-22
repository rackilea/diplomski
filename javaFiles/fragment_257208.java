public void stripRabbitHeaders(@Headers Map headers)
{
    headers.remove("rabbitmq.ROUTING_KEY");
    headers.remove("rabbitmq.DELIVERY_TAG");
    headers.remove("rabbitmq.EXCHANGE_NAME");
}