@Override
protected void onResume() {

    //register receiver for air plane mode states
    IntentFilter airPlaneModeFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
    registerReceiver(airPlaneModeReceiver, airPlaneModeFilter);

    super.onResume();
}

private BroadcastReceiver airPlaneModeReceiver = new BroadcastReceiver() {@Override
    public void onReceive(Context context, Intent intent) {
        boolean airPlaneModeEnabled = intent.getBooleanExtra("state", false);
        if (airPlaneModeEnabled) {

} else {

}
    }
};

@Override
protected void onPause() {
    if (airPlaneModeReceiver != null) unregisterReceiver(airPlaneModeReceiver);

    super.onPause();
}