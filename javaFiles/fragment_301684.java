// Reset the ConnectThread because we're done
 synchronized (BluetoothChatService.this) {
     mConnectThread = null;
 }
 // Start the connected thread
 connected(mmSocket, mmDevice);