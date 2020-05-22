public void onServicesDiscovered(final BluetoothGatt gatt, int status) {
    mBackgroundHandler.post(new Runnable() {
        @Override
        public void run() {
            doRead();
        }
    ).start();
}