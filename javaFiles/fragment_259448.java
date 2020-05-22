@RunWith(SpringRunner.class)
@SpringBootTest(classes = NedBatchApplication.class)
public class CustomReaderTest {

  CustomReader customReader;

  @Mock
  RestApiService restApiService;

  @Before
  private void setup() {
      MockitoAnnotations.initMocks(this);
      Mockito.when(restApiService.getData().thenReturn(expectedData);

      this.customReader = new CustomReader(restApiService);
  }

 @Test
 public void test() {
   customReader.initialize();
   (...)
 }
}