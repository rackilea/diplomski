try
{
  //...do something...
}
catch(SQLException e)
{
  throw new MyAppException(e);
}