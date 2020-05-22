private boolean isMyServiceRunning() {
    ActivityManager manager = (ActivityManager)     getSystemService(Context.ACTIVITY_SERVICE);
    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
        if (MyServiceName.class.getName().equals(service.service.getClassName())) {
            return true;
        }
    }
    return false;
}