private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the battery scale
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);

        // get the battery level
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);

    }
};