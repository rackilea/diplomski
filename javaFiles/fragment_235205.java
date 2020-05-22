public class DatabaseUtils {

    private static DataSource datasource;

    private static synchronized Connection getDBConnection() throws SQLException {
        if (datasource == null) {
            initDataSource();
        }
        return datasource.getConnection();
    }

    public static void initDataSource() {
        try {
             datasource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/DataSource");
             LOG.info("Database connection pool initalized successfully");
        } catch (Exception e) {
            LOG.error("Error while initialising the database connection pool", e);
        }
    }