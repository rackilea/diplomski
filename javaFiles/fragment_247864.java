@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    init();
    if (BtAdapter==null){
        Toast.makeText(getApplicationContext(), "No Bluetooth adapter...",0 ).show();
        finish();
    } elseif (BtAdapter != null && !BtAdapter.isEnabled()){
          Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
          startActivityForResult(intent, 1);
      }
    else{
     GetPairedDevices();
    }

}