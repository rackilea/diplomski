private boolean mockInitialized = false;
@Before
public void setUp() {
    if (!mockInitialized) {
        MockitoAnnotations.initMocks(this);
        mockInitialized = true;  
    }
}