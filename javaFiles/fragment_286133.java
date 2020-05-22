DatagramSocket socket;

public void onSensorChanged() {
    //calculate and create DatagramPacket here
    new Thread(new Runnable() {
        @Override
        public void run() {
            socket.send(packet);    
        }
    });
}