public class SecurityTests extends AbstractJUnit4SpringContextTests {
  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() {
    MockMvc mock = MockMvcBuilders.webApplicationContextSetup(webApplicationContext).build();
  }
}