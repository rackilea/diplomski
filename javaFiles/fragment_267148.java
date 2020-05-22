try {
        mBtSocket = btDevice
                .createRfcommSocketToServiceRecord(BT_SRVC_UUID);
        mBtSocket.connect(); 
    } catch (Exception e) {
        Log.e(TAG, "createInsecureRfcommSocket", e);
        Log.d(TAG, "trying with reflection");

        BluetoothDevice hxm = BluetoothAdapter.getDefaultAdapter()
                .getRemoteDevice(btDevice.getAddress());
        Method m;
        m = hxm.getClass().getMethod("createRfcommSocket",
                new Class[] { int.class });
        mBtSocket = (BluetoothSocket) m.invoke(hxm, Integer.valueOf(1));
        mBtSocket.connect();
    }