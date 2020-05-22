import java.sql.*;  
class OracleConnect{  
public static void main(String args[]){  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@1.1.1.1:1521:DataBase1","User1","password1");  
Statement stmt=conn.createStatement();  
ResultSet rs=stmt.executeQuery("select 1 from dual");  
.
.
conn.close();  
}catch(Exception ex){ System.out.println(ex);}  
}
}