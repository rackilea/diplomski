PersistenceManager pm = PMF.get().getPersistenceManager();
try
{
  //
  // Do your query stuff...
  //
}
catch(Exception e)
{
  //
  // Your code...
  //
}
finally
{
  pm.close();
}