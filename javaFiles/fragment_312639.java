public class ConnectionProvider {  
  public static Connection getConn(){  
    try {  
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/timsheetdb","root","lion");  
    } catch(Exception e){}  

    return null;  
  }  
}