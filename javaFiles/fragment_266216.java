Single.concat(Arrays.asList(
        rxBleMainConnection.writeCharacteristic(COMS_WRITE_CHAR_UUID, bytes0),
        rxBleMainConnection.writeCharacteristic(COMS_WRITE_CHAR_UUID, bytes1),
        rxBleMainConnection.writeCharacteristic(COMS_WRITE_CHAR_UUID, bytes2),
        rxBleMainConnection.writeCharacteristic(COMS_WRITE_CHAR_UUID, bytes3),
        // ...
        rxBleMainConnection.writeCharacteristic(COMS_WRITE_CHAR_UUID, bytesn)
))
        .subscribe(
                characteristicValue -> {
                    // Written characteristic value.
                    Log.d(TAG, "Written command: " + Arrays.toString(characteristicValue));
                },
                throwable -> {
                    // Handle an error here.
                    Log.d(TAG, "Error writing command");
                    throwable.printStackTrace();
                },
                () -> {
                    Log.d(TAG, "All writes completed");
                }
        );