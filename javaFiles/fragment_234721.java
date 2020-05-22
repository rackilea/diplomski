private static final String ACTION_SCR_OFF = "yourpackagename.ACTION_SCREEN_OFF";

private final BroadcastReceiver screenOffReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
};