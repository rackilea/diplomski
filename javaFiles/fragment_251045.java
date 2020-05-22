//receive remote device details including address
BroadcastReceiver mReceiver = new BroadcastReceiver() {
    public void onReceive(Context context, Intent intent) {
        Sring action = intent.getAction();

        // When discovery finds a device
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            // Get the BluetoothDevice object from the Intent
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String deviceAddress =  device.getAddress());
        }
    }
}

//register receiver 
IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
registerReceiver(mReceiver, filter); 

//start bluetooth scan 
BluetoothAdapter mBtAdapter = BluetoothAdapter.getDefaultAdapter();
mBtAdapter.startDiscovery();