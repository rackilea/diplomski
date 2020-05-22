massetBarcode.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        scanQR.setRequestCode(123).initiateScan();
    }
});