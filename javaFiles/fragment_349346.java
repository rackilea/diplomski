import java.sql.*;


public class Class1 {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(  
                    "jdbc:oracle:thin:@//localhost/xe","scott","tiger");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  

        String query =  "insert into tempp values(? , ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String longString1 = "1521142078000";
        String longString2 = "1521566664738";

        long longType1 = Long.parseLong(longString1);
        long longType2 = Long.parseLong(longString2);

        Timestamp d1 = new Timestamp(longType1);
        Timestamp d2 = new Timestamp(longType2);

        ps.setTimestamp(1, d1);
        ps.setTimestamp(2, d2);

        ps.execute();
    }

}