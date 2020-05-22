public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

            // Retrieve the concert data, e.g. the concert title
            String[] message = intent.getStringArrayExtra("alarm_message");
            CharSequence concertTitle = message[0];
            CharSequence messageText = "The concert is starting";
            long when = System.currentTimeMillis();

            NotificationManager mNotificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);

            Notification notification = new Notification(R.drawable.ic_launcher, concertTitle, when);
            notification.flags |= Notification.FLAG_AUTO_CANCEL;

// This will open the activity that will be open then clicked on the push notification
            Intent i = new Intent(context, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) when, i, PendingIntent.FLAG_ONE_SHOT);
            notification.setLatestEventInfo(context, concertTitle, messageText, pendingIntent);

            mNotificationManager.notify(1, notification);
    }

}