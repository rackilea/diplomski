public void join(InetAddress address, int port){
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        try {
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Attempting to join session <" + address.toString() + ":" + port + ">!");
            socket.send(packet);
            System.out.println("Joining......");
        }catch (Exception e){
            System.out.println("Unable to connect, this may be a server error, or you've entered incorrect details!");
        }
}