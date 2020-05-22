public class LoginDbConn {

String uname;
String pwd;
ResultSet rs;
/*
 * public LoginDbConn() { // TODO Auto-generated constructor stub }
 */

public LoginDbConn(String uname, String pwd) {
    this.uname = uname;
    this.pwd = pwd;
}

public ResultSet getConn() {
    try {
        // 0. Register the JDBC drivers
        String driverClass = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driverClass);
        // or DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

        // 1. Get a connection to the Database
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbuname = "scott";
        String dbpwd = "tiger";
        Connection conn = DriverManager.getConnection(dbUrl, dbuname, dbpwd);

        // 2. Create a statement
        // String sql = "SELECT * FROM users WHERE name = '"+uname+"' and
        // password = '"+pwd+"'";
        // Statement st = conn.createStatement();
        String sql = "select * from users where name = ? and password = ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, uname);
        pst.setString(2, pwd);

        // 3. Execute SQL query
        rs = pst.executeQuery();

        // 5. Close Connection
        // conn.close();

        return rs;
    } catch (SQLException | ClassNotFoundException e) {

            // THIS EXCEPTION MUST ABSOLUTELY BE HANDLED
    }
    return rs;
}