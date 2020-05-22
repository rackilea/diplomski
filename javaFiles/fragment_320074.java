public class BetaTest{
    @Mock(name="charlie") // variable name in Beta
    private Charlie charlieMock;

    @InjectMocks
    private Beta beta;

    @BeforeMethod
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    public void test1(){
        beta.doSomethingWithCharlie();
    }
}