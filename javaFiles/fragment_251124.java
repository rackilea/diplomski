/**to register the activity)
public static void setActivityName(Activity activityName){
    anrActivity = activityName;
}

/**This method is called by RestartUtil method to restart the app**/
public static void kill(){
    if ( anrActivity != null) {
        anrActivity.finish();
        anrActivity.finishAffinity();
    }
    android.os.Process.killProcess(android.os.Process.myPid());
}