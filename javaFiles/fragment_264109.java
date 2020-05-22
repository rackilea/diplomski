public class MyReceiver extends BroadcastReceiver{
String Reqpopending;
int MID=0;
@Override
public void onReceive(Context context, Intent intent) {
    // TODO Auto-generated method stub

    for(int i = 0; i < 3; i++)
    {
    long when = System.currentTimeMillis();
    NotificationManager notificationManager = (NotificationManager) context
            .getSystemService(Context.NOTIFICATION_SERVICE);

    Intent notificationIntent = new Intent(context, SplashScreen.class);
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
            notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
            context).setSmallIcon(R.drawable.dashboard)
            .setContentTitle("Dash Board Counts")
            .setContentText("P.O Counts-532,198,654,255,901 ZeroInward-303 PartialInward-777").setSound(alarmSound)
            .setAutoCancel(true).setWhen(when)
            .setContentIntent(pendingIntent)
            .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
    notificationManager.notify((int)when, mNotifyBuilder.build());
    }