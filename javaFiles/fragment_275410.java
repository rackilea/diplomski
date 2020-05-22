public class MyAlarm extends IntentService {
    private NotificationManager myAlarmNotificationManager;

    public MyAlarm() {
        super("MyAlarm");
    }


    //this send the notification
    private void sendNotification(String message) {
        Log.d("MyAlarm", "Preparing to send notification...: " + message);
        myAlarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, AlarmActivity.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Alarm").setSmallIcon(R.drawable.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentText(message);


        alamNotificationBuilder.setContentIntent(contentIntent);
        myAlarmNotificationManager.notify(1, alamNotificationBuilder.build());
        Log.d("MyAlarm", "Notification sent.");
    }


     @Override
    public void onHandleIntent(Intent intent) {
        sendNotification("Do something");
    }
}