public int AddBook(String name,String auth,String year , String avail){
int id=0;

 Connection connection = lockConnection();
boolean ok = false;
String sql = "INSERT INTO BOOKS(ID,NAME, AUTHORS, PUBLISHYEAR, AVAIL)"


        + " VALUES(?,?,?,?,?)";


try{
  PreparedStatement statement = connection.prepareStatement(sql);
  if(statement!=null){
     statement.setInt(1,getMaxBookID(connection));
    statement.setString(2,name);
    statement.setString(3,auther);
    statement.setString(4,year);
    statement.setString(5,avail);




 try{
      int count = statement.executeUpdate();
      ok = count == 1;
      if(!ok)id=0;
    }
    catch(Exception statmentExcption){statmentExcption.printStackTrace();statmentExcption.printStackTrace(); return 0 ;
    }
    statement.close();
  }
} catch (Exception generalException){generalException.printStackTrace(); generalException.printStackTrace(); return 0;
}

closeMyConnection(connection);


return id;


}