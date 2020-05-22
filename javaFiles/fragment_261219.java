Set<BluetoothDevice> pairedDevices = mBluetoothAdapter
            .getBondedDevices();
    if (pairedDevices.isEmpty()) {
        Log.e("bluetooth",
                "No devices paired...");
        return ;
    }

    String MY_MAC_ADDR = getResources().getString(R.string.Bluetooth_MAC);

    for (BluetoothDevice device : pairedDevices) {
        Log.d("Bluetooth", "Device : address : " + device.getAddress() + " name :"
                + device.getName());
        if (MY_MAC_ADDR.equals(device.getAddress())) {
            mmDevice = device;
            break;
        }
    }