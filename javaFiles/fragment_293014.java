public void onServiceConnected(ComponentName className, IBinder service) {
    // Because we have bound to an explicit
    // service that is running in our own process, we can
    // cast its IBinder to a concrete class and directly access it.
    BluetoothLeServiceForLeft.LocalBinder binder = 
             (BluetoothLeServiceForLeft.LocalBinder) service;
    mBluetoothLeServiceForLeft = binder.getService();
    mBoundLeft = true;
    Log.d("ServiceConnection", "Service is connected");
}