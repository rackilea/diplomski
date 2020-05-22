public class SmsTimerService extends BroadcastReceiver {

    private void doAction(Context context, int timeoutInSeconds, ScheduledSms sms) {
        Intent myIntent = new Intent(context, SmsTimerService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
        sms.getRequestCodeForListener(), myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5); // should be timeoutInSeconds instead of         
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // you get to replace sms with something!
        doAction(context, 5, sms); // original u do - > new SmsTimerService(this,5,sms);
    }
}