socket.setSoTimeout(10000);
while(true) {
    DatagramPacket getack = new DatagramPacket(incoming, incoming.length);
    try {
        socket.receive(getack);
    } catch (SocketTimeoutException e) {
       // resend
       socket.send(data);
       continue;
    }
    // check received data...
}