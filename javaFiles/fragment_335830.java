public class AlarmReceiver extends BroadcastReceiver {

PrefUtils timerPreferences = null;
private final static String ALARM_NOTIFICATION = "alarm_notification";
private final int timerOneNotifColor = Color.argb(255, 239, 82, 79);
private final int timerTwoNotifColor = Color.argb(255, 250, 225, 85);
private final int timerThreeNotifColor = Color.argb(255, 94, 171, 92);
private final int timerFourNotifColor = Color.argb(255, 250, 150, 27);
private final int timerOneLightColor = Color.argb(255, 255, 0, 0);
private final int timerTwoLightColor = Color.argb(255, 255, 255, 0);
private final int timerThreeLightColor = Color.argb(255, 0, 255, 0);
private final int timerFourLightColor = Color.argb(255, 255, 55, 0);

private void alarmNotification(int timerNumber, Context context, int notifColor, int lightColor, Intent intent) {
    int timerNumberOneId = intent.getIntExtra("timerNumberOneId", 0);
    int timerNumberTwoId = intent.getIntExtra("timerNumberTwoId", 0);
    int timerNumberThreeId = intent.getIntExtra("timerNumberThreeId", 0);
    int timerNumberFourId = intent.getIntExtra("timerNumberFourId", 0);
    int notifId = 0;

    Uri notification = Uri.parse("android.resource://" + "com.professionalkitchentools.iinewmanii.professionalkitchentimer" + "/" + R.raw.alarm_clock_short);

    intent = new Intent(context, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    PendingIntent sender = PendingIntent.getActivity(context, 1, intent, 0);
    PendingIntent senderTwo = PendingIntent.getActivity(context, 2, intent, 0);
    PendingIntent senderThree = PendingIntent.getActivity(context, 3, intent, 0);
    PendingIntent senderFour = PendingIntent.getActivity(context, 4, intent, 0);

    NotificationCompat.Builder timerNotificationBuilder = new NotificationCompat.Builder(context);
    int lightFlashingInterval = 500;
    timerNotificationBuilder.setPriority(2)
            .setColor(notifColor)
            .setSound(notification)
            .setLights(lightColor, lightFlashingInterval, lightFlashingInterval)
            .setContentTitle("Timer " + timerNumber + " has finished")
            .setContentText("Professional Kitchen Timer")
            .setSmallIcon(R.mipmap.ic_warning_white_24dp)
            .setWhen(System.currentTimeMillis())
            .setShowWhen(true)
            .setGroup(ALARM_NOTIFICATION)
            .setAutoCancel(true);
    if (timerNumberOneId == 1) {
        notifId = 1;
        timerNotificationBuilder.setContentIntent(sender);
    }

    if (timerNumberTwoId == 2) {
        notifId = 2;
        timerNotificationBuilder.setContentIntent(senderTwo);
    }

    if (timerNumberThreeId == 3) {
        notifId = 3;
        timerNotificationBuilder.setContentIntent(senderThree);
    }

    if (timerNumberFourId == 4) {
        notifId = 4;
        timerNotificationBuilder.setContentIntent(senderFour);
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        timerNotificationBuilder.setCategory(CATEGORY_ALARM);
    }

    Notification timerNotification = timerNotificationBuilder.build();
    timerNotification.flags |= Notification.FLAG_INSISTENT;
    NotificationManager timerNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    timerNotificationManager.notify(notifId, timerNotification);
}

@Override
public void onReceive(Context context, Intent intent) {
    timerPreferences = new PrefUtils(context);
    int timerNumberOneId = intent.getIntExtra("timerNumberOneId", 0);
    int timerNumberTwoId = intent.getIntExtra("timerNumberTwoId", 0);
    int timerNumberThreeId = intent.getIntExtra("timerNumberThreeId", 0);
    int timerNumberFourId = intent.getIntExtra("timerNumberFourId", 0);

    if (timerNumberOneId == 1) {
        alarmNotification(timerNumberOneId, context, timerOneNotifColor, timerOneLightColor, intent);
        timerPreferences.setTimerOneRunning(false);
        timerPreferences.setStartTime(0);
        timerPreferences.setOriginalTime(0);
        timerPreferences.setTimerPaused(false);
        timerPreferences.setPausedTime(0);
    }

    if (timerNumberTwoId == 2) {
        alarmNotification(timerNumberTwoId, context, timerTwoNotifColor, timerTwoLightColor, intent);
        timerPreferences.setTimerTwoRunning(false);
        timerPreferences.setStartTimeTwo(0);
        timerPreferences.setOriginalTimeTwo(0);
        timerPreferences.setTimerTwoPaused(false);
        timerPreferences.setPausedTimeTwo(0);
    }

    if (timerNumberThreeId == 3) {
        alarmNotification(timerNumberThreeId, context, timerThreeNotifColor, timerThreeLightColor, intent);
        timerPreferences.setTimerThreeRunning(false);
        timerPreferences.setStartTimeThree(0);
        timerPreferences.setOriginalTimeThree(0);
        timerPreferences.setTimerThreePaused(false);
        timerPreferences.setPausedTimeThree(0);
    }

    if (timerNumberFourId == 4) {
        alarmNotification(timerNumberFourId, context, timerFourNotifColor, timerFourLightColor, intent);
        timerPreferences.setTimerFourRunning(false);
        timerPreferences.setStartTimeFour(0);
        timerPreferences.setOriginalTimeFour(0);
        timerPreferences.setTimerFourPaused(false);
        timerPreferences.setPausedTimeFour(0);
    }
}