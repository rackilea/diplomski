try
{
  mbean.getClass().getMethod("findDeadlockedThreads", new Class<?>[0]);
  return mbean.findDeadlockedThreads();
}
catch(NoSuchMethodException ex)
{
  return mbean.findMonitorDeadlockedThreads();
}