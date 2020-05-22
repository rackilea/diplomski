import java.sql.*;
import java.io.*;
import java.util.*;

public class test1 {

    public static void main(String[] argv) throws Exception {
        try {
            Connection con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/old","user","pass");
            Connection con1 = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/new","user","pass");

            String sql = "INSERT INTO users("+ "name,"+ "active,"+ "login,"+ "password)"+ "VALUES(?,?,?,?)";

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            PreparedStatement pstmt = con1.prepareStatement(sql);

            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String nm = rs.getString(2);
                Boolean ac = rs.getBoolean(3);
                String log = rs.getString(4);
                String pass = rs.getString(5);

                pstmt.setString(1, nm);
                pstmt.setBoolean(2, ac);
                pstmt.setString(3, log);
                pstmt.setString(4, pass);

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("could not get JDBC connection: " +e);
        } finally {
            con.close();
            con1.close();
        }
    }

}