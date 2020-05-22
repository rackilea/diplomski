context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
    @Override
    public void configure() throws Exception {
        // mock only log endpoints
        mockEndpoints("log*");
    }
});

// now we can refer to log:foo as a mock and set our expectations
getMockEndpoint("mock:log:foo").expectedBodiesReceived("Bye World");