public void readCustomCharacteristic() {
    if (mBluetoothAdapter == null || mBluetoothGatt == null) {
        Log.w(TAG, "BluetoothAdapter not initialized");
        return;
    }
    /*check if the service is available on the device*/
    BluetoothGattService mCustomService = mBluetoothGatt.getService(UUID.fromString("UUID of service"));
    if(mCustomService == null){
        Log.w(TAG, "Custom BLE Service not found");
        return;
    }
    /*get the read characteristic from the service*/
    BluetoothGattCharacteristic mReadCharacteristic = mCustomService.getCharacteristic(UUID.fromString("UUID of characteristic"));
    if(mBluetoothGatt.readCharacteristic(mReadCharacteristic) == false){
        Log.w(TAG, "Failed to read characteristic");
    }
}

public void writeCustomCharacteristic(byte[] value) {
    if (mBluetoothAdapter == null || mBluetoothGatt == null) {
        Log.w(TAG, "BluetoothAdapter not initialized");
        return;
    }
    /*check if the service is available on the device*/
    BluetoothGattService mCustomService = mBluetoothGatt.getService(UUID.fromString("UUID of service"));
    if(mCustomService == null){
        Log.w(TAG, "Custom BLE Service not found");
        return;
    }
    /*get the read characteristic from the service*/
    BluetoothGattCharacteristic mWriteCharacteristic = mCustomService.getCharacteristic(UUID.fromString("UUID of characteristic"));
    mWriteCharacteristic.setValue(value);
    if(mBluetoothGatt.writeCharacteristic(mWriteCharacteristic) == false){
        Log.w(TAG, "Failed to write characteristic");
    }
}