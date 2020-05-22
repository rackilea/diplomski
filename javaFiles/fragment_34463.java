private void sendMessageToDevice(String message) {

        .............

        boolean writeResult = mBluetoothGatt.writeCharacteristic(characteristicWrite);

        if(!writeResult)
           mBluetoothGatt.discoverServices();
}