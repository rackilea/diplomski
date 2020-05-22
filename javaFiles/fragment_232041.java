package experiment;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProgramA {
    public static void main(String[] args) {
        try {
            System.out.println("Started");
            DatagramSocket datagramSocket = new DatagramSocket();
            String message = "tokenasdfasdfasdfasdf";
            InetAddress addr = InetAddress.getByName("localhost");
            DatagramPacket datagramLength = new DatagramPacket(new byte[]{(byte)message.length()}, 1, addr, 5556);
            DatagramPacket datagram = new DatagramPacket(message.getBytes(),message.getBytes().length, addr, 5556);
            datagramSocket.send(datagramLength);
            datagramSocket.send(datagram);
            datagramSocket.close();
            System.out.println("Done");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package experiment;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ProgramB {
    public static void main(String[] args) {
        try {
            InetSocketAddress addr = new InetSocketAddress("localhost",     5556);
            DatagramSocket datagramSocket = new DatagramSocket(addr);
            byte[] messageLength = new byte[1];
            DatagramPacket datagramLength = new DatagramPacket(messageLength, 1);
            datagramSocket.receive(datagramLength);
            byte[] message = new byte[(int)messageLength[0]];
            DatagramPacket datagram = new DatagramPacket(message, message.length);
            datagramSocket.receive(datagram);
            datagramSocket.close();
            for(int i = 0; i < message.length; i++) {
                System.out.print((char)message[i]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}