PreparedStatement statement = connection.prepareStatement("insert into MyTable(MYSMALLINT) values(?);"
for(Integer value:values){
   try{
      statement.setInt(1,value);
      statement.addBatch();
   }catch(SQLException e){
      System.err.println("Invalid value: " + e.getMessage());
      throw e;
   }
}
statement.executeBatch();