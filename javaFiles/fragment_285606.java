import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    private static final String CLIENT_IP = "localhost";
    private static final int CLIENT_PORT = 9876;

    public static void main(String args[]) {
        try {
            while (true) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                DatagramSocket clientSocket = new DatagramSocket();
                InetAddress ipAddress = InetAddress.getByName(CLIENT_IP);
                String input = bufferedReader.readLine();
                byte[] sendData = input.getBytes();
                byte[] receiveData = new byte[1024];
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, CLIENT_PORT);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedInput = new String(receivePacket.getData());
                modifiedInput = modifiedInput.trim();
                System.out.println("FROM SERVER:" + modifiedInput);
                clientSocket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}