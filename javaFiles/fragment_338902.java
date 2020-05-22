public static void startListening() {
final BroadcastReceiver mBroadcastReceiver3 = new BroadcastReceiver() {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle info = intent.getExtras();
        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        String deviceAddress =  device.getAddress();
        if (action.equals( BluetoothDevice.ACTION_ACL_CONNECTED)){
            //do some stuff with connected device
        }
        if (action.equals(BluetoothDevice.ACTION_ACL_DISCONNECTED)){
            // do things with disconnected
        }
    }
};}