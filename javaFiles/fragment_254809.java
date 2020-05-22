ActivityManager acitivityManager = (ActivityManager) 
    context.getSystemService(Context.ACTIVITY_SERVICE);
// Get the top of running tasks, limit by 100
List<RunningTaskInfo> tasks = acitivityManager.getRunningTasks(100);
for (RunningTaskInfo taskInfo : tasks) {
    if (YOUR_PACKAGE_NAME.equals(taskInfo.baseActivity.getPackageName())) {
        if (taskInfo.numRunning > 0) {
            // Show dialog
        } else {
            // Show notification
        }
        break;
    }
}