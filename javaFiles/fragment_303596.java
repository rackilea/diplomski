package pkg;

import java.sql.*;

public class MainClass {

    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager
              .getConnection("jdbc:firebirdsql:embedded:D:/data/db/testdatabase.fdb", "sysdba", "")) {
            try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM RDB$DATABASE");
            ) {
                while (rs.next()) {
                    System.out.println(rs.getString(2));
                }
            }
        }
    }
}