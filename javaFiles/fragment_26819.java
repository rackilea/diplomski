public class TestTest extends  CamelSpringTestSupport {
    @Test
    public void test() throws Exception{
        Endpoint beanEP    = context.getEndpoint("beanEP");
        Endpoint requestEP = context.getEndpoint("requestEP");
        context.getRouteDefinition("testRoute").adviceWith( context , new AdviceWithRouteBuilder(){
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint( beanEP.getEndpointUri() ).
                    to("mock:send").
                    skipSendToOriginalEndpoint();
            }
        });    
        context.start();
        TestUtils.waitingFor("Configuration applied", 2000);
        MockEndpoint mockEP = context.getEndpoint("mock:send",MockEndpoint.class);
        mockEP.setExpectedCount( 1 );
        context.createProducerTemplate().sendBody(requestEP, "Message");
        mockEP.assertIsSatisfied();
        TestUtils.waitingFor("All rows commited", 2000);
    }
    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("test-camel.xml");
    }
    @Override
    public boolean isUseAdviceWith(){
        return true;
    }
}