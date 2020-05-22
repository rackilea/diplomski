import java.sql.*;

public class jdbcTest {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};" + 
                    "Dbq=C:\\__tmp\\Database1.accdb;");

            PreparedStatement s = conn.prepareStatement(
                    "INSERT INTO testTable (id, tName, modifyDate) VALUES (?, ?, ?)");
            s.setString(1, "foo");
            s.setString(2, "bar");
            s.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
            s.execute();
            s.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

}