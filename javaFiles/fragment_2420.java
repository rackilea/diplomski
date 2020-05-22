public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception{
        from(dynamicEndpoint("seda", "mySeda", Collections.singletonMap("size", "123")))
                .to("log:Hello from SEDA");
    }

    private Endpoint dynamicEndpoint(String component, String name, Map<String, Object> params) throws Exception {
        return getContext().getComponent(component).createEndpoint(name, params);
    }
}