private Set<String> btDevice = new LinkedHashSet<String>();

private ScanCallback scanCallback = new ScanCallback() {
    @Override
    public void onScanResult(int callbackType, ScanResult result) {

        BluetoothDevice device = result.getDevice();

        ScanRecord record = result.getScanRecord();
        byte[] dataByteArray = record.getBytes();

        if (device.getAddress().startsWith("F8:36:9B")) {
            btDevice.add(device.getAddress());
        }
    }
};