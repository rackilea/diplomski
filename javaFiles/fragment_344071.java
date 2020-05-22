try
{
    List<ActivityManager.RunningAppProcessInfo> tasks = am.getRunningAppProcesses();
    int numOfTasks = tasks.size();
    for(int i = 0; i < numOfTasks; i++)
    {
        ActivityManager.RunningAppProcessInfo task = tasks.get(i);
        try
        {
            PackageInfo myPInfo = getPackageManager().getPackageInfo(task.processName, 0);
            //System.out.println(task.processName);
        }
        catch (PackageManager.NameNotFoundException ne)
        {
         ne.printStackTrace();
        }
    }
}
catch (SecurityException se)
{
 se.printStackTrace();
}