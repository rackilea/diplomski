public class BootAlarmReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
            Intent alarmServiceIntent = new Intent(context, AlarmService.class);
            ComponentName service = context.startService(alarmServiceIntent);

            if (service == null) {
                Log.e("ALARM", "Could not start service");
            } else {
                Log.e("ALARM", "Could start service");
            }
        }
    }
}