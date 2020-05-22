public class Server implements Runnable {
    public void run() {
        while (true) {
            DatagramPacket packet = socket.receive();
            new Thread(new Responder(socket, packet)).start();
        }
    }
}

public class Responder implements Runnable {

    Socket socket = null;
    DatagramPacket packet = null;

    public Responder(Socket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    public void run() {
        byte[] data = makeResponse(); // code not shown
        DatagramPacket response = new DatagramPacket(data, data.length,
            packet.getAddress(), packet.getPort());
        socket.send(response);
    }
}