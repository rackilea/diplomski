import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

class DBCheck {
    private MysqlDataSource dataSource;

    public DBCheck() {
        dataSource = new MysqlDataSource();
    }

    public Connection connect() throws SQLException {
        dataSource.setUser("username");
        dataSource.setPassword("password");
        dataSource.setURL("db url");

        return dataSource.getConnection();
    }

    public static main( String[] args ) {
        Connection conn = null;
        try {
            DBCheck dbc = new DBCheck();
            conn = dbc.connect();
        } catch( SQLException e ) {
            // code to handle exception
        } finally {
            if( conn != null ) {
                conn.close();
            }
        }
    }
}