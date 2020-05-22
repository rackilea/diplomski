import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest{
    private static Connection con = null;
    private static Statement  st  = null;
    private static ResultSet  rs  = null;

    public static void main(String args[]) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Testing1?user=root&password=root");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from users");
            while (rs.next()) {
                System.out.println(rs.getString("Key"));
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}