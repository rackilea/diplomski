public class AlarmService extends IntentService {

PowerManager powerManager;
    PowerManager.WakeLock wakeLock;

public AlarmService() {
        super("");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "FCFCFCFC");

        wakeLock.acquire();

       addNotification();
       sendMAIL();

    }


    public void addNotification() {
    NotificationCompat.Builder builder =
            new NotificationCompat.Builder(getApplicationContext())
                    .setSmallIcon(R.drawable.icon_transperent)
                    .setLights(GREEN, 700, 700)
                    .setContentTitle("Achieve - Alert!")
                    .setContentText("This is a reminder for your deadline!");

    Intent notificationIntent = new Intent(getApplicationContext(), MainMenu.class);
    PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0,     notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT);
    builder.setContentIntent(contentIntent);

    // Add as notification
    NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    builder.setVibrate(new long[] { 0, 1000, 1000, 1000, 1000 });
    manager.notify(0, builder.build());
}

    public void sendMAIL(){

    Mail m = new Mail("youremail@gmail.com", "password");

        String[] toArr = {"toemail@outlook.com"};
        m.setTo(toArr);
        m.setFrom("fromemail@gmail.com");
        m.setSubject("Achieve Alert!");
        m.setBody("This is a reminder about your upcoming assignment or examination!");

        try {
            if(m.send()) {
                Toast.makeText(getApplicationContext(), "Email was sent successfully.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Email was not sent.", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            Log.e("MailApp", "Could not send email", e);
        }


        wakeLock.release();

    }


     @Override
    public void onDestroy() {
        super.onDestroy();
    }
}