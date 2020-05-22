...
@Before
    public void setUp() {
        fakeTicker = new FakeTicker();
        testDataSource = mock(TestDataSource.class);
        errorHandlingLoadingCacheFactory = new ErrorHandlingLoadingCacheFactory(fakeTicker::read);
        loadingCache = errorHandlingLoadingCacheFactory.buildCache("testCache", 1, TimeUnit.HOURS, testDataSource::getObjectWithKey, Runnable::run);
    }
...