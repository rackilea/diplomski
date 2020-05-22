Intent intent = new Intent(context, ZHSplashActivity.class);
    PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);
    Notification n  = new Notification.Builder(context)
            .setContentTitle(context.getResources().getString(R.string.app_name))
            .setContentText(message)
            .setSmallIcon(R.drawable.app_icon)
            .setContentIntent(pIntent)
            .setAutoCancel(true).build();

    NotificationManager notificationManager =
            (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    notificationManager.notify(0, n);