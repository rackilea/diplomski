@Override
public void configure() {
    from("direct:start")
        .onCompletion()
        .process(new Processor() {
            @Override
            public void process(final Exchange exchange) throws Exception {
                LOG.info("Hello, {}", exchange.getIn().getHeader("myHeader"));
            }
        })
        .end()
        .setHeader("myHeader").constant("World!");
    }
}