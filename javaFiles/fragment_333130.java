BroadcastReceiver receiver = new BroadcastReceiver() {

@Override
public void onReceive(Context context, Intent intent) {

        // new push notification is received
        msg = intent.getStringExtra("receivedMessage");
        //Set the toggle button at given position to true
        //Integer.valueOf() converts a string to an Integer value
        //You may need to catch an exception if it cannot be converted
        //You will want to make sure msg does not give a higher value than your item array size.
        adapter.toggleItemOn(Integer.valueOf(msg));
    }
}