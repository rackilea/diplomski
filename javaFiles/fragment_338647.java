public class YourDefinedBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, notifService.class);
    context.startService(service);
    }
}