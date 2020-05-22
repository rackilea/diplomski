preparedstatement.setQueryTimeout(seconds);
ResultSet resultSet = preparedStatement.executeQuery();

while( resultSet.next() ){
     // do some stuff
}