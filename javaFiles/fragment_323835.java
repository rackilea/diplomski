// If bluetooth is not switched on
if ( ! mBluetoothAdapter.isEnabled() ) {
    // Create a system request to enable bluetooth
    Intent enableBtIntent = new Intent( BluetoothAdapter.ACTION_REQUEST_ENABLE );
    // Queue the request to pops the bluetooth dialogue
    startActivityForResult( enableBtIntent, REQUEST_ENABLE_BT );
}
// Standby for device found, Bluetooth may still be disabled at this point
IntentFilter filter = new IntentFilter( BluetoothDevice.ACTION_FOUND );
registerReceiver( mReceiver, filter );
// Now that we are done, bluetooth dialogue will popup
// When it's done Android calls our onActivityResult
// (because we queued it with startActivityForResult).