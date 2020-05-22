NotificationManager manager =
    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    // Support for Android Oreo: Notification Channels
    NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "Channel_name_to_be_displayed_in_Settings",
                NotificationManager.IMPORTANCE_DEFAULT);
    manager.createNotificationChannel(channel);
}