public class CamelCustomFreemarkerLoader extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                Configuration myConfiguration = new Configuration();
                StringTemplateLoader dummyLoader = new StringTemplateLoader();
                dummyLoader.putTemplate("dummy", "Hello from dummy template");
                myConfiguration.setTemplateLoader(dummyLoader);

                FreemarkerComponent freemarkerComponent = getContext().getComponent("freemarker", FreemarkerComponent.class);
                freemarkerComponent.setConfiguration(myConfiguration);

                from("direct:test")
                        .to("freemarker:dummy")
                        .to("mock:result");
            }
        };
    }

    @Test
    public void testCustomTemplateLoader() throws Exception{
        MockEndpoint mockEndpoint = getMockEndpoint("mock:result");
        template.sendBody("direct:test",null);
        mockEndpoint.setExpectedCount(1);
        mockEndpoint.assertIsSatisfied();
        Assert.assertEquals("Hello from dummy template", mockEndpoint.getExchanges().get(0).getIn().getBody());
    }
}