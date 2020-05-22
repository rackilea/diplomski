import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from mysql.proc");

        while (resultSet.next()) {
            System.out.println("GOT A ROW!");
        }

        resultSet.close();
        statement.close();
        conn.close();
    }
}