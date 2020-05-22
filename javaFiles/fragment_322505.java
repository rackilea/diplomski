final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
final List<RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

for (int i = 0; i < recentTasks.size(); i++) 
{
    Log.d("Executed app", "Application executed : " +recentTasks.get(i).baseActivity.toShortString()+ "\t\t ID: "+recentTasks.get(i).id+"");         
}