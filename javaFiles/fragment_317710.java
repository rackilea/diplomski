// assumes...
//     import java.sql.*;
Connection conn=DriverManager.getConnection(
        "jdbc:ucanaccess://C:/__tmp/test/zzz.accdb");
Statement s = conn.createStatement();
ResultSet rs = s.executeQuery("SELECT [LastName] FROM [Clients]");
while (rs.next()) {
    System.out.println(rs.getString(1));
}