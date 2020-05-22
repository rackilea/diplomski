import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCheck {

    public static void main(String[] args) {
        String user = "postgres";
        String password = "postgres";
        String url = "jdbc:postgresql://**docker0->ip-address**/testdb?user="+user+"&password="+password;
        try (
                Connection con = DriverManager.getConnection(url);
                // Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
                System.out.println("\nVersion: "+ rs.getString(1)+"\n");
                System.out.println("Successfully selected the version!");
            }else{
                System.out.println("Failed next!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}