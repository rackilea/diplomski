public BluetoothSocket connect(BluetoothDevice remoteDevice) throws IOException
{
    OPP_UUID = UUID.fromString("00001105-0000-1000-8000-00805f9b34fb");

    // check if remote device is in range...throw exception if out of range
    try
    {
        BluetoothSocket socket = remoteDevice
            .createRfcommSocketToServiceRecord(OPP_UUID);
        socket.connect();
        socket.close();
    }
    catch(IOException ex)
    {
        throw new IOException("out of range",ex);
    }

    // try to connect to service on remote device...throw exception if UUID
    // is not available
    try
    {
        BluetoothSocket socket = remoteDevice
            .createRfcommSocketToServiceRecord(MY_UUID);
        socket.connect();
        return socket;
    }
    catch(IOException ex)
    {
        throw new IOException("no listening server socket",ex);
    }
}