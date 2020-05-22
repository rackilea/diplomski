public void testSendError() throws Exception {
    // first advice the route to replace the input, and catch sending to FTP servers
    context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
        @Override
        public void configure() throws Exception {
            replaceFromWith("direct:input");

            // intercept valid messages
            interceptSendToEndpoint("ftp://hostname/valid")
                .skipSendToOriginalEndpoint()
                .to("mock:valid");

            // intercept invalid messages
            interceptSendToEndpoint("ftp://hostname/invalid")
                .skipSendToOriginalEndpoint()
                .to("mock:invalid");
        }
    });

     // we must manually start when we are done with all the advice with
    context.start();

    // setup expectations on the mocks
    getMockEndpoint("mock:invalid").expectedMessageCount(1);
    getMockEndpoint("mock:valid").expectedMessageCount(0);

    // send the invalid message to the route
    template.sendBody("direct:input", "Some invalid content here");

    // assert that the test was okay
    assertMockEndpointsSatisfied();
}