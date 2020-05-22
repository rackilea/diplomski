@Test
public class MyControllerTest {

    @Mock
    private MyClass mockMyClass;
    @InjectMocks
    private MyController myController;

    @BeforeMethod
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    // do tests...
}