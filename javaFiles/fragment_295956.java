public static int getMaxBookID(Connection connection){
   int id=0;
    String sql = "SELECT  NVL(MAX(ID),0)+1  FROM BOOK ";
    try{
    PreparedStatement statement = connection.prepareStatement(sql);
    if(statement!=null){
    try{
      ResultSet results = statement.executeQuery();
      if(results != null){
        try{
          if(results.next()){
            id = results.getInt(1);
          }
        }
        catch(Exception resultSetException) {resultSetException.printStackTrace();
        }
        results.close();
      }
    }
    catch(Exception statmentExcption){statmentExcption.printStackTrace();
    }
    statement.close();
  }
} catch (Exception generalException){generalException.printStackTrace();
}


return id;

}