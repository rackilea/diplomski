public class JdbcTest {

    private final static String URL = "jdbc:oracle:...";
    private final static String USER = "sa";
    private final static String PASSWORd = "";

    public static TestConnection() {
        Connection c = null;  
        try {    
            Class.forName("oracle.jdbc.driver.OracleDriver");    
            System.out.println("Driver found");    
            System.out.println("Connecting..."); 
            c = DriverManager.getConnection(URL, USER, PASSWORD);    
        } catch (Exception e) {    
            System.out.println(Cannot connect the database);   
        } finally {    
            if (c != null) {       
                c.close();        
            }    
        }    
    }            
}