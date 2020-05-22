Thread t = new Thread(new Runnable() {

    @Override
    public void run() {
        DatagramSocket datagramSocket = null;
        try 
        {
            datagramSocket = new DatagramSocket(9090);
        } catch (SocketException e) { e.printStackTrace(); }    

        byte[] buffer = new byte[100];

        // Create a datagram packet.
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while(true)
        {
            // Receive the packet.
            try {
                datagramSocket.receive(packet);
            } catch (IOException e) { e.printStackTrace(); }

            buffer = packet.getData();          
                // Print the data:
            System.out.println(new String(buffer));
        }
    }
});

t.start();

//go on with main thread