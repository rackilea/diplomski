String select= "select username,password from users where username=? and password=?";//to avoid sql injection
preparedStatement = connection.prepareStatement(select);
preparedStatement.setString(1,name);
preparedStatement.setString(2,password);
............

if(resultSet.next())//condition is true, means record exists in database
{
//stuff to redirection to success
}
else
{
//stuff to access denied
}