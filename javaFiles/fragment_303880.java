public class LidhjaMeSQL {
    public Connection connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "root", "");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            //handle exception here..
        }
    }
}