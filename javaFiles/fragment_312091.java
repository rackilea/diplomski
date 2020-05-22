from("restlet:http://localhost:8400/orders/{id}?restletMethod=post")
    .process(new Processor() {
        @Override
        public void process(final Exchange exchange) throws Exception {
            final String res = "received [" + exchange.getIn().getBody(String.class) + "] with order id = " + exchange.getIn().getHeader("id");
            exchange.getIn().setBody(res);
        }
   });