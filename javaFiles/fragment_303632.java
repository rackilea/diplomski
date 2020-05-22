import java.sql.*;

public class FirstExample {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/databasename";


   static final String USER = "root";
   static final String PASS = "password";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{

       Class.forName("com.mysql.jdbc.Driver");  


      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);


      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "select * from tablename";
      ResultSet rs = stmt.executeQuery(sql);


      while(rs.next()){


         String first = rs.getString(1);
         String last = rs.getString(2);



         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
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
}