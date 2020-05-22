Transaction tx = tm.begin();
try
{
// DO SOMETHING
}
catch (Exception e)
{
   tx.setRollbackOnly(); // Force a rollback for this error
   throw e;
}
finally
{
   if (tx.getStatus() == Status.STATUS_ACTIVE)
      tx.commit();
   else
      tx.rollback();
}