public class SecurityDao {
    private DataSource dataSource;

    public SecurityDao() {
        // Intialize your datasource using DBCP or C3P0
        dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
        dataSource.setDriverClass(MyDriverClass.class);
        dataSource.setJdbcUrl("jdbc:mysql://locahost/mydb");
        dataSource.setUser("username");
        dataSource.setPassword("pwd");

        // Don't forget to clean the pool when Restlet application stop
        // with ComboPooledDataSource#close method
    }

    public boolean hasUserPassword(String user, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // Some SQL request like that
            ps = conn.prepareStatement("select * from <MYTABLE> where USER = ? and PASSWORD = ?");
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return rs.next();
        } catch(Exception ex) {
            (...)
        } finally {
            // close rs
            // close ps
            // close conn
        }
    }
}