import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BazaDana {

    public List<Value> selectAll(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        //Create list of values
        List<Value> values = new ArrayList<Value>();

        try{
            Class.forName("com.mysql.Driver");
            conn =     DriverManager.getConnection("jdbc:mysql://localhost:3306/nameofdb","user","pass");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM mytable");

            while(rs.next()){
                Value v = new Value();
                v.setFirstValue(rs.getString("first_column"));
                v.setSecondValue(rs.getString("second_column"));
                values.add(v);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return values;
    }
}