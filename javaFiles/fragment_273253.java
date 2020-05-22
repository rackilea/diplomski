RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.layout_custom_notification);
        contentView.setImageViewResource(R.id.image_news, R.drawable.ic_launcher);
        contentView.setTextViewText(R.id.tv_news_time, "9:14 AM");
        contentView.setTextViewText(R.id.tv_news_title, "Trump signs order to roll back Obama-era climate policies");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
            .setSmallIcon(icon)
            .setContent(contentView)
            .setContentTitle("Custom Notification")
            .setContentIntent(contentIntent)   
            .setWhen(when);

...
mNotificationManager.notify(1, notificationBuilder.build());