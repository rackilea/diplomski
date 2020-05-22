context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
    @Override
    public void configure() throws Exception {
        // weave the node in the route which has id = bar
        // and replace it with the following route path
        weaveById("bar").replace().multicast().to("mock:a").to("mock:b");
    }
});