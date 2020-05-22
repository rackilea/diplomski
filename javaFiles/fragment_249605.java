public class Database {

private static DataSource dataSource;

static {
    // Getting environment variables I have set in server
    String dbName = System.getProperty("DB_NAME");
    String userName = System.getProperty("DB_USERNAME");
    String password = System.getProperty("DB_PASSWORD");
    String hostname = System.getProperty("DB_HOSTNAME");
    String port = "3306"; //System.getProperty("RDS_PORT");

    PoolProperties p = new PoolProperties();
    p.setUrl("jdbc:mysql://" + hostname + ":" + port + "/" + dbName);
    p.setDriverClassName("com.mysql.jdbc.Driver");
    p.setUsername(userName);
    p.setPassword(password);
    p.setJmxEnabled(true);
    p.setTestWhileIdle(false);
    p.setTestOnBorrow(true);
    p.setValidationQuery("SELECT 1");
    p.setTestOnReturn(false);
    p.setValidationInterval(30000);
    p.setTimeBetweenEvictionRunsMillis(30000);
    p.setMaxActive(20);
    p.setInitialSize(5);
    p.setMaxWait(15000);
    p.setRemoveAbandonedTimeout(60);
    p.setMinEvictableIdleTimeMillis(30000);
    p.setMaxIdle(10);
    p.setLogAbandoned(true);
    p.setRemoveAbandoned(true);
    p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
            "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
    dataSource = new DataSource();
    dataSource.setPoolProperties(p);
}

public static Connection getPoolConnection() {
    try {
        return dataSource.getConnection();
    } catch(SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}