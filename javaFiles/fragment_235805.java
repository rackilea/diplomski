public static Connection connect(String sqlServer, String username, String password, String server, String dbName, String port) throws SQLException{

    String connString;

    switch (sqlServer) {
        case "MSSQL":
            connString = "jdbc:sqlserver://"+server+";database="+dbName+";"; 
            break;
        case "MySQL":
            connString = "jdbc:mysql://"+server+":"+port+"/"+dbName+"?zeroDateTimeBehavior=convertToNull";
            break;
        default:
            connString = "";
            break;
    }
    conn = DriverManager.getConnection(connString,username,password);
    conn.setAutoCommit(false);
    return conn;
}