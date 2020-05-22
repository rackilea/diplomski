@SpringBootTest
public class LottoClientServiceImplTest {

    @MockBean
    SoapServiceBindingStub soapServiceBindingStub;

    @Autowired
    LottoClientServiceImpl lottoClientService;

    @Test
    public void getLastResults() throws Exception {

        RespLastWyniki expected = Fake.generateFakeLastWynikiResponse();
        when(soapServiceBindingStub.getLastWyniki(anyString())).thenReturn(expected);

        LastResults actual = lottoClientService.getLastResults();