@WebAppConfiguration
@ContextConfiguration(classes = {YourSpringConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleResourceTest {

    private MockMvc mockMvc;
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private RestOperations restOperations;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        mockRestServiceServer = MockRestServiceServer.createServer((RestTemplate) restOperations);
    }


    @Test
    public void testMyApiCall() throws Exception {
        // Following line verifies that our code behind /api/my/endpoint made a REST PUT
        // with expected parameters to remote service successfully
        expectRestCallSuccess();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/my/endpoint"))
            .andExpect(status().isOk());
    }

    private void expectRestCallSuccess() {
        mockRestServiceServer.expect(
            requestTo("http://remote.rest.service/api/resource"))
            .andExpect(method(PUT))
            .andRespond(withSuccess("{\"message\": \"hello\"}", APPLICATION_JSON));
    }


}