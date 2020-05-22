int notifiId = (int)((new Date().getTime() /1000L)%Integer.MAX_VALUE);

Intent intent = new Intent("NOTIFICATION_DELETED");
// set id to intent
intent.putExtra("NOTIFICATION_ID", notifiId);

PendingIntent pendintIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
registerReceiver(receiver, new IntentFilter("NOTIFICATION_DELETED"));

notification = new Notification.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.icon_notification)
                .setAutoCancel(true)
                .setDeleteIntent(pendintIntent)
                .build();

notificationManager.notify(notifiId, notification);