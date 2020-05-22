Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);


PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);


Notification not = new NotificationCompat.Builder(this,CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_timer)
        .setContentTitle("Productivity Timer")
        .setContentText("Your Timer is Running")
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_PROGRESS)
        .setOngoing(true)
        .setContentIntent(pendingIntent)
        .build();
     notificationManager.notify(1,not);