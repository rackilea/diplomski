public class AlarmScheduler extends BroadcastReceiver {
    private String EVENT_CATEGORY = "notification_event";
@Override
public void onReceive(final Context context, final Intent intent) {
    Log.d("com.properati.user", "AlarmScheduler.onReceive() called");
    Intent eventService = new Intent(context, AlarmService.class);
    eventService.putExtra(intent.getStringExtra(EVENT_CATEGORY, ""));
    context.startService(eventService);
}