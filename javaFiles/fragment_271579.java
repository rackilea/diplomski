public void startScanning() {
   if(mBluetoothAdapter == null)
     mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

   mBluetoothAdapter.startLeScan(mDeviceFoundCallback);
}