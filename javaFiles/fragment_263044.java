final Consumer consumer = endpoint.createConsumer(new Processor() {
    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class);

        LOG.info("Message processed: " + message);

        ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
        consumerTemplate.doneUoW(exchange);
    }
});