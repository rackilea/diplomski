ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(100);
List <Drawable> applicationDrawables = new ArrayList <Drawable>();
PackageManager pacMgr = getPackageManager();

  for (ActivityManager.RunningTaskInfo runningTask: tasks)
  {
    try {
      applicationDrawables.add (pacMgr.getApplicationIcon(runningTask.topActivity.getPackageName()));
    } catch (NameNotFoundException e) {
      e.printStackTrace();
    }
  }