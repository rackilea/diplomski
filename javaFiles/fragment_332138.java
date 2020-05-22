public class ProductCompositeIntegrationTest {
    @InjectMocks
    private ProductCompositeIntegration productIntegration;

    @Mock
    private ServiceUtils util;

    private MockRestServiceServer mockServer;

    private RestTemplate restTemplate = new RestTemplate();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockServer = MockRestServiceServer.createServer(restTemplate);
        productIntegration.setRestTemplate(restTemplate);
    }

    @Test
    public void someTests() {
        when(util.getServiceUrl("product")).thenReturn(URI.create("http://localhost:8080/test"));
        //Test code...
    }
}