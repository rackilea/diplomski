import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myTest {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/so_gibberish"; // **** MODIFY db name (my db_name is so_gibberish)
        String user = "username";   // **** MODIFY 
        String password = "my_password";    // **** MODIFY 

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            System.out.println("------------------------------");
            rs = st.executeQuery("select version()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println("------------------------------");
           }
            rs = st.executeQuery("select id,myCode from thingws");
            while (rs.next()) {
                System.out.println(rs.getInt(1)+": "+rs.getString(2));
            }
            System.out.println("------------------------------");    

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(myTest.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

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

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(myTest.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}