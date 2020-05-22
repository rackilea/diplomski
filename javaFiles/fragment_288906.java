BluetoothSocket btSocket;
        Toast.makeText(MyActivity.this, "Connecting...", Toast.LENGTH_SHORT).show();
        btSocket.connect();


    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            if (btSocket.isConnected()){
                Toast.makeText(MyActivity.this, "Connected!", Toast.LENGTH_SHORT).show();
            }            }
    }, 5000);