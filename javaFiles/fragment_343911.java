private static final String NOTIFICATION_CHANNEL_ID ="notification_channel_id";
private static final String NOTIFICATION_Service_CHANNEL_ID = "service_channel";
.....
private void startInForeground() {
    int icon = R.mipmap.icon;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
        icon = R.mipmap.icon_transparent;
    }

    Intent notificationIntent = new Intent(this, CurrentActivity.class);
    PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,0);
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
        .setSmallIcon(icon)
        .setContentIntent(pendingIntent)
        .setContentTitle("Service")
        .setContentText("Running...");
    Notification notification=builder.build();
    if(Build.VERSION.SDK_INT>=26) {
        NotificationChannel channel = new NotificationChannel(NOTIFICATION_Service_CHANNEL_ID, "Sync Service", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("Service Name");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);

        notification = new Notification.Builder(this,NOTIFICATION_Service_CHANNEL_ID)
            .setContentTitle("Service")
            .setContentText("Running...")
            .setSmallIcon(icon)
            .setContentIntent(pendingIntent)
            .build();
    }
    startForeground(121, notification);
}