public class Operaciones 
{
   Conexion conexion;

public Operaciones()
{
    conexion = new Conexion();
}


public boolean registra_rechazo(String SKU,String fecha,String num_captura,int pesoCaptura)
{
    Boolean bandera=false;
     try
    {
        Connection conn = conexion.getConecction();
        java.util.Date utilStartDate = new java.util.Date(fecha);
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());           
        String sql = "INSERT INTO registra_rechazo VALUES(?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, SKU);   
        pst.setDate(2, sqlStartDate);
        pst.setString(3, num_captura);
        pst.setInt(4, pesoCaptura);
        if(pst.executeUpdate()!=-1){
            bandera = true;
            return bandera;
        }
        else{
            bandera = false;
            return bandera;

        }

    }
    catch(SQLException Ex)
    {

    }
     return bandera;
   }
}