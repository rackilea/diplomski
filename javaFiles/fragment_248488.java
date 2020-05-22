@RunWith(MockitoJUnitRunner.class)
public class ClientTest {

  private String RESULT = "Assert result";

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private Client client;

  /**
   * any setting needed before load of test class
   */
  @Before
  public void setUp() {
    // not needed as of now
  }

  // testing an exception scenario
  @Test(expected = RestClientException.class)
  public void testSendUserForExceptionScenario() throws RestClientException {

    doThrow(RestClientException.class).when(restTemplate)
        .exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class));
    // expect RestClientException
    client.sendUser();
  }

  @Test
  public void testSendUserForValidScenario() throws RestClientException {

    // creating expected response
    User user= new User("name", "mail", 6609); 
    Gson gson = new Gson(); 
    String json = gson.toJson(user); 
    doReturn(new ResponseEntity<String>(json, HttpStatus.OK)).when(restTemplate)
        .exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), any(Class.class));
    // expect proper response
    ResponseEntity<String> response =
        (ResponseEntity<String>) client.sendUser();
    assertEquals(this.RESULT, HttpStatus.OK, response.getStatusCode());
  }
}