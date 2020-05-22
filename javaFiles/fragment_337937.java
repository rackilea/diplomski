import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionJSon {

    static String driver = "com.mysql.jdbc.Driver";
    static String DB_username = "root";
    static String DB_password = "admin";
    static String DB_URL = 
            "jdbc:mysql://localhost:3306/d3?useUnicode=true&characterEncoding=utf-8";

    public static void main(String[] args) throws Exception {
        try {

            Connection connection = DriverManager.getConnection(DB_URL, 
                    DB_username, DB_password);
            String q = "INSERT INTO table1 VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1, "இந்தியா நாட்டின்");
            int exc = preparedStatement.executeUpdate();
            System.out.println(exc);
            q = "SELECT * FROM table1";
            preparedStatement = connection.prepareStatement(q);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println("Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}