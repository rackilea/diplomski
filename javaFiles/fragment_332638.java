@WebAppConfiguration
@ContextConfiguration(classes = RestApplication.class)
public class RestApplicationContextTest extends
    AbstractTestNGSpringContextTests {

  private static final String FULL_USER_URL = "http://localhost:10403/users";
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @BeforeMethod
  public void init() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  private static String createTestRecord(int identifier) {
    String testingRecordString =
        "{\"email\": \"user%d@gmail.com\", \"name\": \"User%d\"}";
    return String.format(testingRecordString, identifier, identifier,
        identifier);
  }

  @Test
  public void testPost() throws Exception {
    // GIVEN
    String testingRecord = createTestRecord(0);

    // WHEN
    // @formatter:off
    MvcResult mvcResult = mockMvc.perform(post(FULL_USER_URL)
        .contentType(MediaType.APPLICATION_JSON)
        .content(testingRecord))
        .andReturn();
    // @formatter:on

    // THEN
    int httpStatus = mvcResult.getResponse().getStatus();
    assertEquals(httpStatus, HttpStatus.CREATED.value());
  }
  ...