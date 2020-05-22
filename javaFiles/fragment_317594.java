// check if bluetooth is available
if(mBluetoothAdapter == null){
    mBluetoothStatus.setText("Bluetooth is not available");
}
else {
    mBluetoothStatus.setText("Bluetooth is available");
    //if Bluetooth isnt enabled, enable it
    if (!mBluetoothAdapter.isEnabled()) {
        Intent enableBtIntent = new 
            Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
    }
}