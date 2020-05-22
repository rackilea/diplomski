public class ArangoDriverCacheTest {

    private static final String COLLECTION_NAME = "unitTestCollection";
    private static final String DATABASE_NAME = "unitTestDatabase";
    private static ArangoConfigure configure;
    private static ArangoDriver driver;

    @BeforeClass
    public static void setup() throws ArangoException {

        configure = new ArangoConfigure();
        configure.init();
        driver = new ArangoDriver(configure);

        // // create test database
        try {
            driver.createDatabase(DATABASE_NAME);
        } catch (final ArangoException e) {
        }
        driver.setDefaultDatabase(DATABASE_NAME);

        // create test collection
        try {
            driver.createCollection(COLLECTION_NAME);
        } catch (final ArangoException e) {
        }
        driver.truncateCollection(COLLECTION_NAME);

        // create some test data
        for (int i = 0; i < 1000000; i++) {
            final TestEntity value = new TestEntity("user_" + (i % 10), "desc" + (i % 10), i);
            driver.createDocument(COLLECTION_NAME, value);
        }

    }

    @AfterClass
    public static void shutdown() {
        try {
            driver.deleteDatabase(DATABASE_NAME);
        } catch (final ArangoException e) {
        }
        configure.shutdown();
    }

    private AqlQueryOptions createAqlQueryOptions(
        final Boolean count,
        final Integer batchSize,
        final Boolean fullCount,
        final Boolean cache) {
        return new AqlQueryOptions().setCount(count).setBatchSize(batchSize).setFullCount(fullCount).setCache(cache);
    }

    @Test
    public void test_withoutCache() throws ArangoException {
        // set cache mode off
        final QueryCachePropertiesEntity properties = new QueryCachePropertiesEntity();
        properties.setMode("off");
        driver.setQueryCacheProperties(properties);

        exceuteQuery(false);
    }

    @Test
    public void test_withCache() throws ArangoException {
        // set cache mode on
        final QueryCachePropertiesEntity properties = new QueryCachePropertiesEntity();
        properties.setMode("on");
        driver.setQueryCacheProperties(properties);

        // set caching to true for the query
        exceuteQuery(true);
    }

    private void exceuteQuery(final boolean cache) throws ArangoException {

        final AqlQueryOptions aqlQueryOptions = createAqlQueryOptions(true, 1000, null, cache);
        final String query = "FOR t IN " + COLLECTION_NAME + " FILTER t.age >= @age SORT t.age RETURN t";
        final Map<String, Object> bindVars = new MapBuilder().put("age", 90).get();

        DocumentCursor<TestEntity> rs = driver.executeDocumentQuery(query, bindVars, aqlQueryOptions, TestEntity.class);
        // first time, the query isn't cached
        Assert.assertEquals(false, rs.isCached());

        final long start = System.currentTimeMillis();

        // query the cached value
        rs = driver.executeDocumentQuery(query, bindVars, aqlQueryOptions, TestEntity.class);
        Assert.assertEquals(cache, rs.isCached());

        // load all results
        rs.asEntityList();

        final long time = System.currentTimeMillis() - start;
        System.out.println(String.format("time with cache=%s: %sms", cache, time));
    }

    private static class TestEntity {
        private final String user;
        private final String desc;
        private final Integer age;

        public TestEntity(final String user, final String desc, final Integer age) {
            super();
            this.user = user;
            this.desc = desc;
            this.age = age;
        }
    }
}