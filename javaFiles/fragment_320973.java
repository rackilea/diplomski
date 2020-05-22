@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MethodNameControllerTest {
    @LocalServerPort
    private int port;

    @Value("${server.contextPath}")
    private String contextPath;
    private String base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = "http://localhost:" + port;
    }

    @Test
    public void testMethodNameMappingResolving() throws Exception {
        TestRestTemplate template = new TestRestTemplate();
        String url = base + contextPath + "/common/test";
        String res1 = template.getForObject(url, String.class);
        assertThat(res1, equalTo("test"));

        url += "2";
        String res2 = template.getForObject(url, String.class);
        assertThat(res2, equalTo("test2"));
    }

}