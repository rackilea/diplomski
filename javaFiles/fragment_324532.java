private static final String USERNAME = "root";
private static final String PASSWORD = "password";
private static final String CONN_STRING = "jdbc:mysql://localhost:3306/test";

public static void main(String[] args) {
    Connection conn = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        System.out.println("Connected");
    }catch (SQLException e){
    System.err.println(e);
    }
}