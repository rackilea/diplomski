private Connection connect() {
    // SQLite connection string
    String url = "jdbc:derby://localhost:1527/MyDataBase";
    String username = "LouwDataBase"; 
    String password = "1234"; 
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return conn;

}