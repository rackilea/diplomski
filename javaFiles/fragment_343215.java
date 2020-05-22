@Mock
private Set<String> mySet;

@Before
public void doBefore() throws Exception {
    MockitoAnnotations.initMocks(this.getClass()); //this should create mocks for your objects...
}