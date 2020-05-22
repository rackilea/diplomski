private static final String DBNAME = String.format("JDBITest-%d", System.currentTimeMillis());
private ManagedDataSource dataSource;

@Before
public void setUp() {
    System.out.println("Server started and connection is open.");

    final String url = String.format("jdbc:h2:mem:%s;", DBNAME) +
            "MODE=MySQL;" +
            "TRACE_LEVEL_FILE=3;" +
            "DB_CLOSE_DELAY=-1;" +
            "IGNORECASE=TRUE";
    System.out.println("Creating in memory H2 using " + url);

    DataSourceFactory config = new DataSourceFactory();
    BootstrapLogging.bootstrap();
    config.setUrl(url);
    config.setUser("sa");
    config.setDriverClass("org.h2.Driver");
    config.setValidationQuery("SELECT 1");

    dataSource = config.build(null, "test");
}

@Test
public void test() throws SQLException {
    Connection connection = dataSource.getConnection();

    connection.createStatement().executeUpdate("CREATE TABLE TEST (`id` INT)");
    connection.createStatement().executeUpdate("INSERT INTO TEST (`id`) VALUES (1)");
    ResultSet resultSet1 = connection.createStatement().executeQuery("SELECT * FROM TEST WHERE `id` = 1");
    resultSet1.next();
    resultSet1.getInt(1);

    System.out.println("Found ID: " + resultSet1.getInt(1));
}