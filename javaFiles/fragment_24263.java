private void toggleNotificationListenerService() { 
    PackageManager pm = getPackageManager(); 

    pm.setComponentEnabledSetting(new ComponentName(this, your.NotificationListenerServiceImpl.class), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    pm.setComponentEnabledSetting(new ComponentName(this, your.NotificationListenerServiceImpl.class), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
}