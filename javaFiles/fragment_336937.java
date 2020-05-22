// receive request
    DatagramPacket recvRequest = new DatagramPacket(buf, buf.length);

    socket.receive(recvRequest);

    //Some process of data in datagram
    (new Thread(new Runnable() {
        public void run () {
            // do stuff with data in buf
            ...
        }
    })).start();

} catch (IOException e) {
    e.printStackTrace();
}