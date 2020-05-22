private void createNotification() {

    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    // only create notification channel if SDK >= 26
    if (android.os.Build.VERSION.SDK_INT >= 26) {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription(CHANNEL_DESC);
        manager.createNotificationChannel(channel);
    }

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_notify_more)
            .setContentTitle(remoteMessage.getNotification().getTitle())
            .setContentText(remoteMessage.getNotification().getBody());


    manager.notify(1, builder.build());

}