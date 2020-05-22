private class AcceptThread extends Thread {
    private final BluetoothServerSocket mBluetoothServerSocket;
    public AcceptThread() {
        BluetoothServerSocket localBluetoothServerSocket;
        try {
            localBluetoothServerSocket = ...
        } catch (IOException e) { 
            localBluetoothServerSocket = ...
        }
        mBluetoothServerSocket = localBluetoothServerSocket;
    }
}