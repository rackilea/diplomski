private boolean isServiceRunning(String serviceName){
boolean serviceRunning = false;
ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
List<ActivityManager.RunningServiceInfo> l = am.getRunningServices(50);
Iterator<ActivityManager.RunningServiceInfo> i = l.iterator();
while (i.hasNext()) {
    ActivityManager.RunningServiceInfo runningServiceInfo = i
            .next();

    if(runningServiceInfo.service.getClassName().equals(serviceName)){
        serviceRunning = true;

        if(runningServiceInfo.foreground)
        {
            //service run in foreground
        }
    }
}
return serviceRunning;