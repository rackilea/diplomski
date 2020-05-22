Connection dbConnection = null;
PreparedStatement preparedStatement = null;
String insertTableSQL = "insert into subscriber(name, street_address, city, state, zip, email, login, password) values(?, ?, ?, ?, ?, ?, ?, ?)";

try{

   dbConnection = getDBConnection();
   preparedStatement = dbConnection.prepareStatement(insertTableSQL);

   preparedStatement.setString(1, name);
   preparedStatement.setString(2, street_address);
   preparedStatement.setString(3, city);
   preparedStatement.setString(4, state);
   preparedStatement.setString(5, zip);
   preparedStatement.setString(6, email);
   preparedStatement.setString(7, login);
   preparedStatement.setString(8, password); 
   preparedStatement.executeUpdate();


} catch (Exception e){
 e.printStackTrace();   
} finally {
   preparedStatement.close();
   dbConnection.close();
}