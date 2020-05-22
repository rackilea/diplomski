private Connection conn;

public Connection getConn(){
    if(conn == null || conn.isClosed)
        conn = DriverManager.getConnection(server, user, pass);
    return conn;
}