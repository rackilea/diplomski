@RunWith(MockitoJUnitRunner.class)
public class SubjectTest {

@InjectMocks
private CarCar subject;
@Mock
private RestTemplate restTemplate;

@Test
public void getCarModelDetails_valid() throws JSONException {
    String id = "123";
    Config config = new Config();
    when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(QueryResultCar.class)))
            .thenReturn(new ResponseEntity<>(new QueryResultCar(), HttpStatus.OK));

    Car actual = subject.getCarModelDetails(id);

    ArgumentCaptor<HttpEntity> httpEntityArgumentCaptor = ArgumentCaptor.forClass(HttpEntity.class);
    verify(restTemplate).exchange(eq(config.restUrl + "/v" + config.restVersion + "/query?q=SELECT + SELECT_COLUMNS"
            + " FROM Car WHERE (Model = '" + id + "')"), eq(HttpMethod.GET), httpEntityArgumentCaptor.capture(), eq(QueryResultCar.class));
    assertEquals(APPLICATION_JSON_VALUE, httpEntityArgumentCaptor.getValue().getHeaders().get("Accept").get(0));
    assertEquals("Car to string", actual.toString());
}