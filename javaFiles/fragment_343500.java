public class ScrFileRouter extends RouteBuilder {

    // Configured fields
    private String camelRouteId;

    @Override
    public void configure() throws Exception {
        // Add a bean to Camel context registry
        AbstractCamelRunner.getRegistry(getContext(), SimpleRegistry.class).put("testString", "this is a test");

        from("file:/tmp/in6?noop=true").routeId(camelRouteId)
        .to("file:/tmp/out6");
    }
}