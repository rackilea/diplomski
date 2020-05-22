import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
    private static final int SERVER_PORT = 9876;

    public static void main(String args[]) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
            while(true) {
                byte[] receiveData = new byte[1024];
                byte[] sendData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String input = new String(receivePacket.getData());
                input = input.trim();
                System.out.println("RECEIVED: " + input);
                InetAddress ipAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                String capitalizedInput = input.toUpperCase();
                sendData = capitalizedInput.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
                serverSocket.send(sendPacket);
                Thread.sleep(50);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}