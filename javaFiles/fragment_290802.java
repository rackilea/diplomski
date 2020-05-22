public class MySqlConnection
{
    private static String dbUrl = "jdbc:mysql://localhost:3306/database";
    private static String dbUsername = "root";
    private static String dbPassword = "mysql";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}