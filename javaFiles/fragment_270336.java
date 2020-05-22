public void setAlarm() {

    Intent serviceIntent = new Intent(this, CheckRecentRun.class);
    PendingIntent pi = PendingIntent.getService(this, 131313, serviceIntent,
                                                PendingIntent.FLAG_CANCEL_CURRENT);

    AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, pi);
    Log.v(TAG, "Alarm set");        
}
public void sendNotification() {

    Intent mainIntent = new Intent(this, MainActivity.class);
    @SuppressWarnings("deprecation")
    Notification noti = new Notification.Builder(this)
        .setAutoCancel(true)
        .setContentIntent(PendingIntent.getActivity(this, 131314, mainIntent,
                          PendingIntent.FLAG_UPDATE_CURRENT))
        .setContentTitle("We Miss You!")
        .setContentText("Please play our game again soon.")
        .setDefaults(Notification.DEFAULT_ALL)
        .setSmallIcon(R.drawable.ic_launcher)
        .setTicker("We Miss You! Please come back and play our game again soon.")
        .setWhen(System.currentTimeMillis())
        .getNotification();

    NotificationManager notificationManager
        = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(131315, noti);

    Log.v(TAG, "Notification sent");        
}