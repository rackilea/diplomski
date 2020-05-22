import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class SoQuestion {
    private static class Publisher {
        private DatagramSocket socket;
        private InetAddress address;
        private int port;

        private int count = 1;

        public Publisher(int port, String host) 
            throws SocketException, UnknownHostException {
            this.port = port;
            address = InetAddress.getByName(host);
            socket = new DatagramSocket();
        }

        public void publish(int packets) {
            System.out.println(
                "Publishing " + packets + 
                " packets via UDP to port " + this.port
                );

            for (int i = 1; i <= packets; i++,count++) {

                String data = "" + count;
                byte[] dataBytes = data.getBytes();

                DatagramPacket packet = new DatagramPacket(
                    dataBytes,
                    dataBytes.length,
                    address,
                    port
                    );

                try {
                    socket.send(packet);
                    System.out.println(data + " sent");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Subscriber extends Thread {

        private int port;
        private String host;

        private InetAddress address;
        private DatagramSocket socket;

        private byte[] buffer = new byte[1024*1024];
        private volatile boolean finished;

        public Subscriber(int port, String host) throws SocketException{
            this.port = port;
            this.host = host;
        }

        @Override
        public void run() {
            try {
                address = InetAddress.getByName(host);
                socket = new DatagramSocket(port, address);
                socket.setSoTimeout(5000);

                System.out.println("Subscribed via UDP to port " + port);
                while (!finished) {

                    DatagramPacket packet = new DatagramPacket(
                        buffer,
                        buffer.length
                        );

                    socket.receive(packet);
                    System.out.println(
                        new String(
                            packet.getData(), 
                            0, 
                            packet.getLength()
                            ) + " received"
                        );

                }

                System.out.println("Subscription finished");
            } catch (SocketTimeoutException x ) {
                System.out.println("Subscription timed-out.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void finish() {
            this.finished = true;
        }
    }

    public static void main(String[] args) {
        try {
            int packets = 1024;

            Publisher publisher = new Publisher(9000, "localhost");
            publisher.publish(packets);

            Subscriber subscriber = new Subscriber(9000, "localhost");
            subscriber.start();

            Thread.sleep(2000);

            publisher.publish(packets);

            //subscriber.finish();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}