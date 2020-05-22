public class DBConnection {
    private static String url = null;
    private static Connection conn = null;
     public static Connection getConnection(){
     try{

       Class.forName("com.mysql.jdbc.Driver");
       url = "jdbc:mysql://localhost:3306/e_manager";

     conn = DriverManager.getConnection(url,"root","2timeLearning!");
     }   catch (Exception e) {
            System.out.println(e);
        } 
     return conn;
     }
}