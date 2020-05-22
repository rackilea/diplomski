public class Test{

    @Mock
    private Service service;

    @Captor
    private ArgumentCaptor<ArrayList<SomeType>> captor;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test 
    public void shouldDoStuffWithListValues() {
        //...
        verify(service).doStuff(captor.capture()));
    }
}