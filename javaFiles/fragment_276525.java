public class GCMBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Explicitly specify that GcmIntentService will handle the intent.
        ComponentName comp = new ComponentName(context.getPackageName(),
                GCMIntentService.class.getName());
        // Start the service, keeping the device awake while it is launching.
        // startWakefulService(context, (intent.setComponent(comp)));

        //setResultCode(Activity.RESULT_OK);

        GCMIntentService.enqueueWork(context, (intent.setComponent(comp)));
    }
}