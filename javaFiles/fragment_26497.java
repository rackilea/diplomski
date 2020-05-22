NotificationManager notification_manager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    String chanel_id = "3000";
    CharSequence name = "Channel Name";
    String description = "Chanel Description";
    int importance = NotificationManager.IMPORTANCE_LOW;
    NotificationChannel mChannel = new NotificationChannel(chanel_id, name, importance);
    mChannel.setDescription(description);
    mChannel.enableLights(true);
    mChannel.setLightColor(Color.BLUE);
    notification_manager.createNotificationChannel(mChannel);
    notification_builder = new NotificationCompat.Builder(this, chanel_id)
} else {
    notification_builder = new NotificationCompat.Builder(this);
}
notification_builder.setSmallIcon(R.drawable.ic_launcher)
        .setContentTitle("Notification Title")
        .setContentText("Notification Body")
        .setAutoCancel(true)
        .setContentIntent(pending_intent);