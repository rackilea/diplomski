// This will load the MySQL driver, each DB has its own driver
  try
  {
  Class.forName("com.mysql.jdbc.Driver");
  }
  catch(ClassNotFoundException e)
  {
  e.printStackTrace();
  }

  // Now you can setup the connection with the DB
   Connection connection=null;
   try {
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","username", "password");
 } 
 catch (SQLException e) 
 {
    System.out.println("Connection Failed..!");
    e.printStackTrace();
}