private void sendDataToPairedDevice(String message ,BluetoothDevice device){       
           byte[] toSend = message.getBytes();
            try {
                UUID applicationUUID = UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");
                BluetoothSocket socket = device.createInsecureRfcommSocketToServiceRecord(applicationUUID);
                OutputStream mmOutStream = socket.getOutputStream();
                mmOutStream.write(toSend);
                // Your Data is sent to  BT connected paired device ENJOY.
            } catch (IOException e) {
                Log.e(TAG, "Exception during write", e);
            }
        }