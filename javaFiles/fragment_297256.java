public class YourService extends IntentService {

    private static final String EXTRA_FAILED_ATTEMPTS = "com.your.package.EXTRA_FAILED_ATTEMPTS";
    private static final String EXTRA_LAST_DELAY = "com.your.package.EXTRA_LAST_DELAY";
    private static final int MAX_RETRIES = 10;
    private static final int RETRY_DELAY = 1000;

    public YourService() {
        super("YourService");
    }

    @Override
    protected final void onHandleIntent(Intent intent) {

        // Your other code obtaining your info string.

        try {
            // Make your http call.
            ApiBridge.getInstance().makeHttpCall(info);
        } catch (Exception e) {
            // Get the number of previously failed attempts, and add one.
            int failedAttempts = intent.getIntExtra(EXTRA_FAILED_ATTEMPTS, 0) + 1;
            // if we have failed less than the max retries, reschedule the intent
            if (failedAttempts < MAX_RETRIES) {
                // calculate the next delay
                int lastDelay = intent.getIntExtra(EXTRA_LAST_DELAY, 0);
                int thisDelay;
                if (lastDelay == 0) {
                    thisDelay = RETRY_DELAY;
                } else {
                    thisDelay = lastDelay * 2;
                }
                // update the intent with the latest retry info
                intent.putExtra(EXTRA_FAILED_ATTEMPTS, failedAttempts);
                intent.putExtra(EXTRA_LAST_DELAY, thisDelay);
                // get the alarm manager
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                // make the pending intent
                PendingIntent pendingIntent = PendingIntent
                        .getService(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                // schedule the intent for future delivery
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + thisDelay, pendingIntent);
            }
        }
    }
}