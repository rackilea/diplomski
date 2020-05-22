public class SQL {
    private final static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private final static String USERNAME = "secret";
    private final static String PASSWORD = "secret";
    private final static String URL = "secret";

    private final static DataSource dataSource;

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(DRIVER_CLASS_NAME);
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(USERNAME);
        basicDataSource.setPassword(PASSWORD); 
        dataSource = basicDataSource;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}