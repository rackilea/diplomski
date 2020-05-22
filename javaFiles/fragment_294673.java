public class DBConnection {
    private static String url = null;
    private static Connection conn = null;
     public static Connection getConnection(){
     try{

       Class.forName("com.mysql.jdbc.Driver");
       url = "jdbc:mysql://localhost:3306/usuarios";

     conn = DriverManager.getConnection(url,"root","admin");
     }   catch (Exception e) {
            System.out.println(e);
        } 
     return conn;
     }
}