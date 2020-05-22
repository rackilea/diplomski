private boolean isNotificationServiceRunning() {
ContentResolver contentResolver = getContentResolver();
String enabledNotificationListeners =
        Settings.Secure.getString(contentResolver, "enabled_notification_listeners");
String packageName = getPackageName();
return enabledNotificationListeners != null && enabledNotificationListeners.contains(packageName);