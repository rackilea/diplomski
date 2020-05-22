@Before
public void setup(){
    MockitoAnnotations.initMocks(this);
    agent = Mockito.spy(new Agent("David", "1"));
    time = dateFormat.format(new Date());
}