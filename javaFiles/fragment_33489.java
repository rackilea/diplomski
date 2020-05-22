@RunWith(MockitoJUnitRunner.class) 
public class ServiceTest {
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    @Spy
    Service service;
    ResponseEntity responseEntity = mock(ResponseEntity.class);

    @Test
    public void test() throws Exception {
        Mockito.when(restTemplate.getForEntity(
                Mockito.anyString(),
                ArgumentMatchers.any(Class.class)
                ))
                .thenReturn(responseEntity);
        boolean res = service.isEnabled("something");
        Assert.assertEquals(res, false);
    }