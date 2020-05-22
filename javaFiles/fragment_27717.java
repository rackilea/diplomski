if (!mBluetoothAdapter.isEnabled()) {
        Intent enableIntent = new Intent(
                BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        // Otherwise, setup the session
    } else {
        if (mService == null) {
            setMService();
        }
    }