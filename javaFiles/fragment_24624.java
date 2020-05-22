@RunWith(SpringJUnit4ClassRunner.class)
   @WebAppConfiguration
   public class StockPlanControllerTest {

    @Autowired
    public WebApplicationContext context;
    public MockMvc mockMvc;
    @Before
    public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

  @Test
  public void POST(String path, Map<String, String> parameters) throws URISyntaxException, IOException {

   mockMvc.perform(post(path)
    .contentType(MediaType.APPLICATION_JSON)
    .param("paramkey", "paramvalue"))
    .andExpect(status().isOk());
   }