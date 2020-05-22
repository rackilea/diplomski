Exchange exchangeRequest = lProducerTemplate.request(endpoint,
    new Processor() {
        public void process(Exchange exchange) throws Exception {

            exchange.getIn().setBody(payload);
            exchange.getIn().setHeaders(headers);
}});