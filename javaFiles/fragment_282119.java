@Before
public void init() {
    Map<String, DataBaseRepository> repos = new HashMap<>(); //you can leave this empty or add in a bunch of mocks of your own
    datasetController = spy(new DatasetController(repos));
    MockitoAnnotations.initMocks(this);

    //add your mocked repos to the repos map as needed after mocks are initialized
}