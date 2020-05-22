public void startScanning() {

        btScanner = btAdapter.getBluetoothLeScanner();
        if (btScanner == null) {
            // not enabled yet or not supported
            return;
        }

        System.out.println("start scanning");
        peripheralTextView.setText("");
        startScanningButton.setVisibility(View.INVISIBLE);
        stopScanningButton.setVisibility(View.VISIBLE);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                btScanner.startScan(leScanCallback);
            }
        });
    }