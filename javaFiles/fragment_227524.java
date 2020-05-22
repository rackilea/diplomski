public class DatabaseConnectionManager {

    DataSource ds;

    public void init() {
        InitialContext initialContext = new InitialContext();
        ds = (javax.sql.DataSource)initialContext.lookup("jdbc/JCGExampleDB");
    }

    public Connection getConnection() {
        if(ds == null) init();

        return ds.getConnection();
    }
}