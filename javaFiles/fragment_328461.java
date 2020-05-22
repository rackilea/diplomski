@RunWith(SpringRunner.class)
@RestClientTest({QrKeyApiClient.class})
@Category(IUnitTest.class)
public class QrKeyApiClientTest {

  @Value("${getQrCodeUrl}")
  private String getQrCodeUrl;

  @MockBean
  LoginApiClient loginApiClient;

  @Autowired
  private MockRestServiceServer server;

  @Autowired
  private QrKeyApiClient client;

  @Test
  public void getQrCodeAsImage_makesTrueCallToApi() throws Exception {    
    this.server
        .expect(requestTo(this.getQrCodeUrl))
        .andExpect(method(HttpMethod.POST))
        .andRespond(withSuccess("successResult", MediaType.TEXT_PLAIN));

    String qrImage = this.client.getQrCodeAsImage(qrCodeGenerateRequest);

    server.verify();

    assertThat(qrImage, is(notNullValue(String.class)));
  }
}