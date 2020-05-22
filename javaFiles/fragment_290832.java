import java.sql.*;
class ExecuteSqlQuery {
 public static void main(String[] args) {
  try {
  Class.forName("com.mysql.jdbc.Driver").newInstance();
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
  Statement st=con.createStatement();
  String str = "CREATE TABLE user(id INTEGER, " + "name VARCHAR(25), address VARCHAR(100), primary key(id))";
  st.executeUpdate(str);
  System.out.println("Table is created into the database.");
  st.executeUpdate("insert into user(id,name,address) values(1111,'roseindia','Rohini,Delhi')");
  System.out.println("Row is inserted.");
   st.close();
  con.close();
  } 
   catch (Exception ex) {
  System.out.println("Unable to connect to database.");
  }
  }
}