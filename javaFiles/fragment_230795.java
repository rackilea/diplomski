@RunWith(Parameterized.class)
@SpringBootTest
@ContextConfiguration(classes = MyConfig.class)
public class MyTest {
    private TestContextManager testContextManager;

    @Before
    public void before() throws Exception {
        testContextManager = new TestContextManager(getClass());
        testContextManager.prepareTestInstance(this); 
        ...
    }