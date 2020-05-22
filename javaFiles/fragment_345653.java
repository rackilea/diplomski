public void onServiceConnected(ComponentName className, IBinder rawBinder) {
    mService = ((UartService.LocalBinder) rawBinder).getService();
    Log.d(TAG, "onServiceConnected mService= " + mService);
    if (!mService.initialize()) {
        Log.e(TAG, "Unable to initialize Bluetooth");
        finish();
    }
    mDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(deviceAddress);
    mService.connect(deviceAddress);
}