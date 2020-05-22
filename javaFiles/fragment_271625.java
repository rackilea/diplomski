jcomeau@intrepid:/tmp$ cat dbconnection.java; javac dbconnection.java; sudo java -cp .:/usr/share/maven-repo/mysql/mysql-connector-java/5.1.16/mysql-connector-java-5.1.16.jar  dbconnection
import java.sql.*;
public class dbconnection {
 public static void main(String args[]) {
  String name = "";
  String port = "3306";
  String user = "root";
  String pass = "";
  String dbname = "imagetagging";
  String host="127.0.0.1";
  try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   String url = "jdbc:mysql://"+host+":"+  port + "/" + dbname;
   System.out.println("URL:" + url);
   //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con = DriverManager.getConnection(url, user, pass);
   String qry2 = "select * from taggers";
   Statement st = con.createStatement();
   ResultSet rs = st.executeQuery(qry2);
   while (rs.next()) {
    name = rs.getString(1);
    System.out.println("Name:" + name);
   }
   rs.close();
   st.close();
   con.close();
  } catch (Exception e) {
   System.out.println("Exception:" + e);
  }
 }
}
URL:jdbc:mysql://127.0.0.1:3306/imagetagging
Name:1
Name:2
Name:3
Name:4
Name:5
Name:6
Name:7
Name:8
Name:9
Name:10
Name:11
Name:12
Name:13
Name:14
Name:15
Name:16
Name:17
Name:18
Name:19
Name:20
Name:21