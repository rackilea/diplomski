public class TimeAlarm extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MyIntentService.class);
        context.startService(i);
    }
}