public class MyResourceTest {

    public static final String BASE_URI = "http://localhost:8080/api/";
    private HttpServer server;

    @Before
    public void setUp() throws Exception {
        final ResourceConfig rc = new ResourceConfig(Service.class);
        server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);       
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testService() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URI).path("service");
        ...
    }
}