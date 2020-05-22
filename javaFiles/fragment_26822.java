public void configure() throws Exception {
    from("direct:input")
        .convertBodyTo(String.class)
        .process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                final String xmlBody = exchange.getIn().getBody(String.class);
                final String jsonBody = XML.toJSONObject(xmlBody).toString();
                exchange.getIn().setBody(jsonBody);
            }
        })
        .log("************* My body in json format is ${body} *********")
        .to("mock:output");                
}