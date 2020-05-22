public Object onRetainNonConfigurationInstance() 
{
  if (table != null) // Check that the object exists
      return(table);
  return super.onRetainNonConfigurationInstance();
}