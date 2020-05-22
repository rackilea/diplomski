public class ServiceTest {

    @BeforeMethod(groups="serviceTest")
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }


    @Test(groups="serviceTest")
    public void testGetService_returns200() {
        when(serviceDao.getService(any(String.class), any(RestTemplate.class), any(HttpHeaders.class))).thenReturn(new ResponseEntity(new Object(), HttpStatus.OK));

        ObjectRequest request = new ObjectRequest();
        // set request values
        ResponseEntity testResponse = apiService.getObject(request);

    }
}