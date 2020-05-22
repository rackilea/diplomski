import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Example {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:memory:sampleDB;create=true");
             Statement statement = connection.createStatement()
        ) {
            char[] pw = "password".toCharArray();
            statement.execute("create table sample(pw char(10))");

            try (ResultSet resultSet = statement.executeQuery("select * from sample");
                 PreparedStatement preparedStatement = connection.prepareStatement("insert into sample values (?)")
            ) {
                for (int i = 1; i <= 10; i++) {
                    preparedStatement.setString(1, new String(pw) + i);
                    preparedStatement.execute();                    
                }

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }
        }
    }
}