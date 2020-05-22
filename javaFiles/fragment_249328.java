@RunWith(MockitoJUnitRunner.class)
    public class YourClassNameTest{

    @InjectMocks
    YourClassUnderTest myClass;
    private String data;

    @Before
    public void setUp() throws Exception {

    //prepare you data here
    // any other mock action you can set here
    }

    @Test
    public void testPostRequestinTransactionService() throws Exception {
    //Write you test here
    String result=myClass.postRequestinTransactionService(data);
    assertThat("result should be blablabla", result, is("blablabla");
    }