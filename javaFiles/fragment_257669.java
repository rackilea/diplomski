public void onServicesDiscovered(final BluetoothGatt gatt, int status) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            doRead();
        }
    ).start();
}