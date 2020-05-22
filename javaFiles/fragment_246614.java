ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
 List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

 long currentMillis = Calendar.getInstance().getTimeInMillis();        
 Calendar cal = Calendar.getInstance();

 for (ActivityManager.RunningServiceInfo info : services) {
     cal.setTimeInMillis(currentMillis-info.activeSince);

     Log.i(TAG, String.format("Process %s with component %s has been running since %s (%d milliseconds)",
             info.process, info.service.getClassName(), cal.getTime().toString(), info.activeSince));
 }