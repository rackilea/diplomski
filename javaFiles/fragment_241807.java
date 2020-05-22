context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
    @Override
    public void configure() throws Exception {
        // mock all endpoints
        mockEndpoints();
    }
});

getMockEndpoint("mock:direct:start").expectedBodiesReceived("Hello World");