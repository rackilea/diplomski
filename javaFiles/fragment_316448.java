private final BroadcastReceiver finishReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        finish();
    }
};