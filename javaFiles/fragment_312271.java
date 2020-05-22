Connection connection = DBConnector.getConnection();
 try {        
     st = connection .prepareStatement(sqlQuery);
     // more code
  } catch (...) {
     // more code
  finally
    {
        try {
            connection.close(); // 
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }