private void sendNotification() {
    // Send notifications to watch
    NotificationCompat.Builder notificationBuilder =
            new NotificationCompat.Builder(getApplicationContext())
                    .setContentTitle(getResources().getString(R.string.app_name))
                    .setContentText(Integer.toString(mStepsCount) + " " +
                            getResources().getString(R.string.steps))
                    .setSmallIcon(R.mipmap.ic_notification_fitwatch);

    // Get an instance of the NotificationManager service
    NotificationManagerCompat notificationManager =
            NotificationManagerCompat.from(getApplicationContext());

    // Build the notification and issues it with notification manager.
    notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
}