@InjectMocks
    private AWSSQSConfig awssqsConfig;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(awssqsConfig, "AWSSqsEndpoint", "putYourEndpointHere");
    }