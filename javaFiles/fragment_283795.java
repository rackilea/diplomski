private void sendNotification(String msg)
{
    int uniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
    mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
            | Intent.FLAG_ACTIVITY_SINGLE_TOP
            | Intent.FLAG_ACTIVITY_NEW_TASK);
    PendingIntent contentIntent = PendingIntent.getActivity(this, uniqueId,
            intent, PendingIntent.FLAG_UPDATE_CURRENT);

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentTitle("Hello")
            .setStyle(new NotificationCompat.BigTextStyle().bigText("Hello"))
            .setContentText("This is your notification content")
            .setAutoCancel(true)
    mBuilder.setContentIntent(contentIntent);

    mNotificationManager.notify(uniqueId, mBuilder.build());
}