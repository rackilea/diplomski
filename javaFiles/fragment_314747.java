public class Conexion {

public Conexion(){

}    
public Connection getConecction()
{
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/controldecalidad", "root", "");                        
    }catch(SQLException ex){            
    }
    catch(Exception ex){
    }
    return con;
    }    
}