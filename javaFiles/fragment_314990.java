private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Extract data included in the Intent
        // String message = intent.getStringExtra("message");

        if (mAdapter!= null) {
            mAdapter.notifyDataSetChanged();
        }
    }
};