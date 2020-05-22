private class ConnectingThread extends Thread {

public ConnectingThread(BluetoothDevice device) {



    BluetoothSocket temp = null;
    BluetoothDevice bluetoothDevice = device;

    // Get a BluetoothSocket to connect with the given BluetoothDevice
    try {
        temp = bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
    } catch (IOException e) {
        e.printStackTrace();
    }
    bluetoothSocket = temp;


}