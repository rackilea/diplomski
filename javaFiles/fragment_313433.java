import java.io.File;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

    public static void main(String args[]) throws Exception {

        FileWriter fw = new FileWriter(new File(
                "D:/outtt.txt"));
        fw.write("hi");
        try {
            // DatagramSocket serverSocket = new DatagramSocket(4555);
            DatagramSocket Socket = new DatagramSocket(4555);
            byte[] receiveData = new byte[1000000];
            // byte[] sendData = new byte[1024];
            // while(true)
            while (receiveData != null) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData,
                        receiveData.length);
                Socket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                fw.write(sentence.trim());
                fw.flush();
                System.out.printf("RECEIVED: %s ", new String(receivePacket
                        .getData()));
                // System.out.println("Done");
                // InetAddress IPAddress = receivePacket.getAddress();
                // int port = receivePacket.getPort();
                // String capitalizedSentence = sentence.toUpperCase();
                /*
                 * sendData = capitalizedSentence.getBytes(); DatagramPacket
                 * sendPacket = new DatagramPacket(sendData, sendData.length,
                 * IPAddress, port); serverSocket.send(sendPacket);
                 */
            }

            fw.flush();
            fw.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }
}