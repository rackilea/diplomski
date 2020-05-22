from("direct:start").to(cxfUri).process(new Processor() {

    @Override
    public void process(Exchange exchange) throws Exception {
        MessageContentsList list = exchange.getIn().getBody(MessageContentsList.class);
        if (list.size() > 0) {
            exchange.getIn().setBody(list.get(0));
        }
    }
});