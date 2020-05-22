//try to connect to the nxt
try {
    socket_nxt1 = nxt_1.createRfcommSocketToServiceRecord(UUID
            .fromString("00001101-0000-1000-8000-00805F9B34FB"));
        socket_nxt1.connect();
    success = true;

} catch (Exception e) {
    Log.i("Bluetooth","Err: Device not found or cannot connect");
    success=false;
}