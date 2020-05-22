@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class MySpringBootRouterTest {

    @Autowired
    SpringCamelContext defaultContext;

    @EndpointInject("mock:foo")
    private MockEndpoint mockFoo;
    @EndpointInject("mock:bar")
    private MockEndpoint mockBar;

    @Test
    @DirtiesContext
    public void getDetails() throws Exception {
        assertNotNull(defaultContext);
        mockBar.expectedHeaderReceived("test_header", "test");
        mockBar.expectedMinimumMessageCount(5);
        MockEndpoint.setAssertPeriod(defaultContext, 5_000L);
        MockEndpoint.assertIsSatisfied(mockFoo, mockBar);
        mockFoo.getExchanges().stream().forEach( exchange -> assertEquals(exchange.getIn().getBody(),"Hello World"));

        //This works too
        //mockBar.assertIsSatisfied();
        //mockFoo.assertIsSatisfied();
    }

    @Before
    public void attachTestProbes() throws Exception {
        //This is Camel 3.0 API with RouteReifier
        RouteReifier.adviceWith(defaultContext.getRouteDefinition("hello_route"), defaultContext, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
           //Hook into the current route, intercept log endpoints and reroute them to mock
                interceptSendToEndpoint("log:foo").to("mock:foo");
                interceptSendToEndpoint("log:bar").to("mock:bar");
            }
        });
    }

}