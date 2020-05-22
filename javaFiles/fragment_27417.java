public class MyRouteTest extends CamelTestSupport {

    @Test
    public void test() throws InterruptedException {
        template.sendBody("direct:in", "testBody");

        MockEndpoint wiretapEndpoint = getMockEndpoint("mock:wiretap");
        wiretapEndpoint.expectedMessageCount(0);
        wiretapEndpoint.assertIsSatisfied();

        MockEndpoint outEndpoint = getMockEndpoint("mock:out");
        outEndpoint.expectedMessageCount(1);
        outEndpoint.assertIsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {

            boolean shouldWireTap = false;

            @Override
            public void configure() {
                from("direct:in")
                    .filter().constant(shouldWireTap)
                        .wireTap("mock:wiretap").end()
                    .end()
                .to("mock:out");
            }
        };
    }
}