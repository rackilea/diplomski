public class NotificationReceiver extends BroadcastReceiver{

    static String powiadomienie;

    @Override
    public void onReceive(Context context, Intent intent) {
             powiadomienie = intent.getStringExtra("Value");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context, RepeatingActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri alarmSound = Uri.parse("android.resource://com.example.kuba.dsadsax/" + R.raw.audio);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Weź pigułke")
                .setContentText(powiadomienie)
                .setSound(alarmSound)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true);
        notificationManager.notify(100, builder.build());


    }


}