public class CreateConnection {
    String driver = "com.mysql.jdbc.Driver";
    String DB_username = "root";
    String DB_password = "pass";
    String DB_URL = "jdbc:mysql://localhost:3306/DATABASE";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_username, DB_password);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception " + e);
            return null;
        }
    }
}