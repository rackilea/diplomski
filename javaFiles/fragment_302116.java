public class ExampleTest {

    @Mock
    private YourClass something;

    @InjectMocks
    private AnotherClass sut;

    @Rule
    public final MockitoRule mockito = MockitoJUnit.rule();

    @Test
    public void shouldDoSomething() {
        //test code
    }
}