NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    Notification notification = new NotificationCompat.Builder(this)
            .setContentTitle(...)
            .setContentText(...)
            .setSmallIcon(...)
            .setContentIntent(pendingIntent)
            .build();

    manager.notify(NOTIFICATION_ID, notification);