Notification.Builder nb = new Notification.Builder(context)
    .setContentTitle("title")
    .setContentText("content")
    .setAutoCancel(true)
    .setColor(getResources().getColor(R.color.primary))
    .setLargeIcon(largeIcon)
    .setSmallIcon(small_icon)
    .setTicker(s.getText());
    NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
    nm.notify(100, nb.build());