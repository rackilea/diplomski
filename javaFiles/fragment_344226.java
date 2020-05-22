public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        boolean startAtBoot = prefs.getBoolean("start_at_boot", false) {
        if (startAtBoot) {
            // do something here
        }
    }
}