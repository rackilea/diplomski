//stop scan button functionality
    stopButton=(Button)findViewById(R.id.stop_button);
    stopButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            spinner.setVisibility(View.INVISIBLE);
            scanHandler.removeCallbacksAndMessages(null);
            mLEScanner.stopScan(mScanCallback);
        }
    });