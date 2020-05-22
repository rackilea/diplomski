public class RouteTests extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start")
                        .filter().method(ValidationProcessor.class, "validate")
                        .to("mock:result");
            }
        };
    }

    @Test
    public void testSendMatchingMessage() throws Exception {
        ObjectMapper objectmapper = new ObjectMapper();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("test.json");
        JSONObject testJson = new JSONObject(objectmapper.readValue(stream, Map.class));

        MockEndpoint resultEndpoint = getMockEndpoint("mock:result");
        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:start", testJson);
        resultEndpoint.assertIsSatisfied();
    }
}