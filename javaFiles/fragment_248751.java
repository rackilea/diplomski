PreparedStatement stmt=null;
boolean isFound=false;
try{
   connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/USERS", "root", "root");
   String sql="SELECT userName FROM employees WHERE UserName=? and Password=?";
   stmt=connection.prepareStatement(sql);
   stmt.setString(1,txtUser.getText());
   stmt.setString(2,txtPass.getPassword());             
   resultSet=stmt.executeQuery();
   if(resultSet.next()){
     isFound=true;
   }
  //     
}catch(SQLException ex){
   System.err.println(ex);
}finally{
  if(stmt!=null){
      try{ 
         stmt.close();
      }catch(Exception ex) { /* */ }
  }
 if(connection!=null){
      try{ 
         connection.close();
      }catch(Exception ex) { /* */ }
  }
}