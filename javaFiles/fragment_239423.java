import java.sql.*;
public class Validate
{
   public static boolean userIsAdmin(String employee_id, String password)
   {
    boolean st = false;
    try { 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_system", "root", ""); 
        PreparedStatement ps = con.prepareStatement("select * from employee_login where employeeID = ? and pwd = ? AND admin=1");
        ps.setString(1, employee_id);
        ps.setString(2, password);
        ResultSet rs =ps.executeQuery();
         st = rs.next();

     }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   

  public static boolean userIsNotAdmin(String employee_id, String password)
   {
    boolean st = false;
    try { 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_system", "root", ""); 
        PreparedStatement ps = con.prepareStatement("select * from employee_login where employeeID = ? and pwd = ? AND admin=0");
        ps.setString(1, employee_id);
        ps.setString(2, password);
        ResultSet rs =ps.executeQuery();
         st = rs.next();

     }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }  
}