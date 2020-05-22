ReadRouteBuilder extends RouteBuilder {
        private final Processor exceptionProcessor;
        private final Processor responseProcessor;

    @Override
    public void configure() throws Exception {
       from(endpoint)
           // you can configure exception processor in OnException clause
           .onException(Exception.class).process(exceptionProcessor)
           .end()
           .when(matches("CLIENT_A")).process("processorForClientA")
           .when(matches("CLIENT_B")).process("processorForClientB")
           .when(matches("CLIENT_C")).process("processorForClientC")
           .when(matches("CLIENT_D")).process("processorForClientD")
           // And so forth
           .otherwise().process(defaultProcessor)
           .process(responseProcessor);
           }

       protected Predicate matches( String clientId) {
            return 
             exchangeProperty("CLIENT_ID").isEqualToIgnoreCase(clientId);
        }