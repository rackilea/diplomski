public void showSmallNotification(String title, String message, Intent intent) {
    PendingIntent resultPendingIntent =
            PendingIntent.getActivity(
                    mCtx,
                    ID_SMALL_NOTIFICATION,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT
            );


    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx);
    Notification notification;
    notification = mBuilder.setSmallIcon(R.mipmap.ic_launcher).setTicker(title).setWhen(0)
            .setAutoCancel(true)
            .setContentIntent(resultPendingIntent)
            .setContentTitle(title)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(), R.mipmap.ic_launcher))
            .setContentText(message)
            .build();

    notification.flags |= Notification.FLAG_AUTO_CANCEL;
    Random random = new Random();
    int m = random.nextInt(9999 - 1000) + 1000;


    NotificationManager notificationManager = (NotificationManager)     mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(m, notification);
}