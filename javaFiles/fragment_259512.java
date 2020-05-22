callableStatement = con.prepareCall(storedProcedure); 
callableStatement.setInt(1, getID()); 
callableStatement.execute(); 
ResultSet resultSet = callableStatement.getResultSet(); 
while (resultSet.next()) { 
   int returnedID = resultSet.getInt(1); 
   String returnedName = resultSet.getString(2);   
}