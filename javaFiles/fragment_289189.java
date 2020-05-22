public void showNotification()
{
NotificationManager manageNotification = (NotificationManager)
        getSystemService(Context.NOTIFICATION_SERVICE);

Notification buildNoti = new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.jelly)
        .setContentTitle("Feeling Jelly")
        .setContentText("Tap to launch Jar of Jelly")
        .setContentIntent(emptyPending)
        .build();

PendingIntent contentIntent = PendingIntent.getActivity(this, 0,new Intent(this, Activity_you_needto_launch.class), PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);

manageNotification.notify(0,buildNoti);
}