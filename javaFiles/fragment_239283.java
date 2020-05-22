from(env.getProperty("in.route")).process(new  Processor {
    public void process(Exchange exchange) throws Exception {
        //you token logic
        String token = "--token logic-------"
        exchange.getIn().setHeader("Authorization", token)

    }
}).to(env.getProperty("rest.endpoint.path"))