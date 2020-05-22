Connection conn;
try{
    //conn = DriverManager.getConnection(CONNECTION,p);
      conn = getCurrentConnection();
}catch(SQLException e){
    return e.toString();
}