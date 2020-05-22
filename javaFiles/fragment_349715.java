public class MyCommand {
    private final MyService service;

    @Inject
    public MyCommand(MyService service) {
        this.service = service;
    }

    public boolean executeSomething() {
        return service.doSomething() > 0;
    }
}

@RunWith(MockitoJUnitRunner.class)
public class MyCommandTest {
    @Mock
    MyServiceImpl serviceMock;
    private MyCommand command;

    @Before public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        when(serviceMock.doSomething()).thenReturn(-1); // <- Error here

        // inject without Guice
        command = new MyCommand(serviceMock);
    }
}