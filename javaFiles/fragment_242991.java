BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "BroadcastReceiver.onReceive()");

        if (CALL_FROM_PLUGIN.equals(action)) {
            Log.d(TAG, "Received call from Plugin");
            // DO YOUR STUFF HERE
        } 
    }
};