BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();    
if (mBluetoothAdapter.isEnabled()) {
    mBluetoothAdapter.disable(); 
    Thread.sleep(500); //code for dealing with InterruptedException not shown
    mBluetoothAdapter.enable(); 
}