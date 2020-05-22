public class ExampleTest {

    @Mock
    private YourClass something;

    @InjectMocks
    private AnotherClass sut;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldDoSomething() {
        //test code
    }
}