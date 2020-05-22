import java.sql.DriverManager;
import java.sql.SQLException;

public class CreerConnection {

    static String driver = "com.mysql.jdbc.Driver";
    static String DB_username = "youcef";
    static String DB_password = "youcef";
    static String DB_URL = "jdbc:mysql://85.10.205.173/bd_test";

    public static void main(String[] args) {
        try {
            Class.forName(driver);
            java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_username, DB_password);
            System.out.println("Success");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception : " + e);
        }
    }
}