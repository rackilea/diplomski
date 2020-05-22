@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ExampleTest {

    @Mock
    private YourClass something;

    @InjectMocks
    private AnotherClass sut;

    @Test
    public void shouldDoSomething() {
        //test code
    }
}