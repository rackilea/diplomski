@Mock
private RestTemplate mockRestTemplate;

@InjectMocks
private ClassUnderTest classUnderTest;

@Before
public void prepare() {
    MockitoAnnotations.initMocks(this);
}