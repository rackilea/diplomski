public void onClick(View v){

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext())
            .setTicker(tickerText)
            .setSmallIcon(android.R.drawable.stat_notify_more)
            .setAutoCancel(true)
            .setContentIntent(mContentIntent)

            NotificationManagerCompat mNotificationManager = NotificationManagerCompat.from(getApplicationContext());
            mNotificationManager.notify(MY_NOTIFICATION_ID,notificationBuilder.build());
        }