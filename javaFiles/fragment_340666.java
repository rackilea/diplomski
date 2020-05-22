String appname = context.getResources().getString(R.string.app_name);
    NotificationManager notificationManager = (NotificationManager) context
            .getSystemService(Context.NOTIFICATION_SERVICE);
    int currentapiVersion = android.os.Build.VERSION.SDK_INT;
    Notification notification;

    Intent intent = new Intent(context, NotificationActivity.class);

    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra("message", YOUR_DATA);

    int requestID = (int) System.currentTimeMillis();
    PendingIntent contentIntent = PendingIntent.getActivity(context, requestID,
            intent, 0);

    if (currentapiVersion < android.os.Build.VERSION_CODES.HONEYCOMB) {
        notification = new Notification(icon, message, when);
        notification.setLatestEventInfo(context, appname, message,
                contentIntent);
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify((int) when, notification);

    } else {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context);
        notification = builder.setContentIntent(contentIntent)
                .setSmallIcon(icon).setTicker(appname).setWhen(when)
                .setAutoCancel(true).setContentTitle(appname)
                .setContentText(message).build();

        notificationManager.notify((int) when, notification);

    }