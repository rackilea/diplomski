query1 = "insert into tabla(cedula, actividad, mercado) "
        + " values ('val', 'GAM', 'GAM' )";
query2 = "insert into tabla(cedula, actividad, mercado) "
        + " values ( ? , ? , ? )";

PreparedStatement pstmt = conexion.prepareStatement(query2); 
pstmt.setString(1, n.getCedula()); 
  //the rest of the sets of the statement continue here from 1 to 13
pstmt.executeUpdate(); 

conexion.createStatement().execute(query1);