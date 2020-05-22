public void onNotificationRemoved(StatusBarNotification sbn) {
    String packageName = sbn.getPackageName();
    try {
        List<AndroidAppProcess> processes = ProcessManager.getRunningAppProcesses();
        if (processes != null) {
            for (AndroidAppProcess process : processes) {
                String processName = process.name;
                if (processName.equals(packageName)) {
                    if (process.foreground ==true)
                    {
                        //user clicked on notification
                    }
                    else
                    {
                        //user swipe notification
                    }
                }
            }
        }
    }
    catch (Exception e)
    {
        String error = e.toString();
    }
}