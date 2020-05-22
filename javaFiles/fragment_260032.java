static {
    try{
        //Driver para MySQL
        Class.forName("com.mysql.jdbc.Driver");
    } catch(ClassNotFoundException e){
        System.out.println(e);
    }
 }

 public ConexionBD() {
 }

  public Connection getConexion(){
    Connection conn = null;
    try {
         conn = DriverManager.getConnection(host,user,password);
         if (conn!=null){
            System.out.println("Se conecto a la base de datos "+bd+"");
         }
    } catch(SQLException e){
        System.out.println("Error en la ejecución:" + e.getErrorCode() + " " + e.getMessage());
    }
    return conn; 
  }