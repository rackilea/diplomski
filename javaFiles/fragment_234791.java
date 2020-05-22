@RunWith(MockitoJUnitRunner.class)
public class FeatureFlipperManagerTest {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Service service;

    MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

    @Test
    public void test() throws Exception {
      mockServer.expect(requestTo(Mockito.anyString()))
                .andRespond(withSuccess("{\"enabled\":true}", MediaType.APPLICATION_JSON));
        boolean res = service.isEnabled("xxx");
        mockServer.verify();
        Assert.assertEquals(true, res);
    }
}