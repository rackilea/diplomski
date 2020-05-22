@RunWith(MockitoJUnitRunner.class)
public class MyCommandTest {
    @Mock
    MyServiceImpl serviceMock;
    @InjectMocks 
    private MyCommand command;

    @Before 
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        command = new MyCommand();
        when(serviceMock.doSomething()).thenReturn(-1); // <- Error here
    }
}