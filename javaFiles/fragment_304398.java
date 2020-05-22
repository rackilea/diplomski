private void createReminder(Notification notification) {
    Intent notificationIntent = new Intent(this, NotificationPublisher.class);
    notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
    notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    long delay = alarmCalendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
    long futureInMillis = SystemClock.elapsedRealtime() + delay;
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
}

private Notification getNotification() {
    String channelId = "Reminders";
    PendingIntent newEntryActivityPendingIntent = PendingIntent.getActivity(this, 1, new Intent(this, NewEntryActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
            .setContentTitle(getString(R.string.app_name))
            .setContentText(getString(R.string.reminder_content))
            .setTicker(getString(R.string.app_name))
            .setSmallIcon(R.drawable.notebook_notification_white)
            .setDefaults(Notification.DEFAULT_SOUND)
            .setAutoCancel(true)
            .setContentIntent(newEntryActivityPendingIntent);
    Log.i(TAG, "notification built");
    return builder.build();
}