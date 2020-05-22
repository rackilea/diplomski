@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ResourceEndpointIntegrationTest{
    @Context
    private HttpServletRequest httpReq;

    private static Logger logger = Logger.getLogger(ResourceEndpointIntegrationTest.class);

    public static final String BASE_URI = "http://localhost:8989/";
    private static HttpServer server = null;

    @BeforeClass
    public static void initTest() {
        RestAssured.baseURI = "http://localhost:8989/";
    }
...
}