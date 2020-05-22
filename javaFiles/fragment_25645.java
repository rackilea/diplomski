public class MyReceiver extends BroadcastReceiver {

    private final String ACTION = "ACTION_ALARM";
    private String ACTION_ONE = "ALARM_REPEAT";

    @Override
    public void onReceive(Context context, Intent intent) {
       try {
            String action = intent.getStringExtra(ACTION);
            new ShowToast(context, action);
            if (action.length() > 1) {
                if (action.equals(ACTION_ONE) ) {
                  String time[] = intent.getStringArrayExtra("Time");
                  startService(context, action);
                }
            }
        } catch (Exception e) {
        }

    }

    public void startService(Context context, String action) {
        Intent service1 = new Intent(context, NotifyService.class);
        service1.putExtra(ACTION, action);
        context.startService(service1);
    }

}