//Query Paired Devices
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            // If there are paired devices
            List<String> items = new ArrayList<String>();
            if (pairedDevices.size() > 0) {
                // Loop through paired devices
                for (BluetoothDevice device : pairedDevices) {
                    // Add the name and address to an array adapter to show in a ListView
                    items.add(device.getName() + "\n" + device.getAddress());
                }
            }

           // Create an Array Adapter to Add Devices to
            ArrayAdapter<String> itemsAdapter;
            itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);