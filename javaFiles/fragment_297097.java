@Stateless
public class MyJdbcBean {

    @Resource(lookup = "jdbc/ConnectionPoolName")
    private DataSource dataSource;

    public Connection getConnection() {
        if (dataSource != null) {
            return dataSource.getConnection();
        } else {
            Exception ex = new ExceptionInInitializerError("Couldn't initialize data source!");
            Logger.getLogger(MyJdbcBean.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            throw ex;
        }
    }
}