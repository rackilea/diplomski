public class Alarmer extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    private void showNotification(Context context) {

        Random r = new Random();
        int r0 = r.nextInt();

        Uri soundUri = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("app_name")
                .setContentText("something" + r0)
                .setContentIntent(
                        PendingIntent.getActivity(context, 0, new Intent(context,
                                MainActivity.class),
                                PendingIntent.FLAG_UPDATE_CURRENT))
                .setSound(soundUri).setSmallIcon(R.drawable.ic_launcher)
                .setAutoCancel(true).setOnlyAlertOnce(true).build();

        // NotificationManagerCompat.from(this).notify(0, notification);
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        nm.notify(r0, notification);

    }

}