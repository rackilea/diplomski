package justtest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6667);
        byte[] sendDatagram = new byte[1054];
        byte[] receiveDatagram = new byte[1054];

        System.out.println("Server Start");
        try
        {
            while (true) 
            {


                DatagramPacket receivePacket = new DatagramPacket(receiveDatagram, receiveDatagram.length);
                datagramSocket.receive(receivePacket);
                //System.out.println("len" + receivePacket.getLength());
                String receive = new String(receivePacket.getData());
                System.out.println(receive.trim() + " received...");

                //////// Do it what you want here //////////
                //////// done //////////////////////////////


                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                String msgClient = "Hola Mundo";

                System.arraycopy(msgClient.getBytes(), 0, sendDatagram, 0, msgClient.getBytes().length);
                DatagramPacket sendPacket = new DatagramPacket(sendDatagram, sendDatagram.length, IPAddress, port);
                datagramSocket.send(sendPacket);

            }
        }
        finally
        {
            datagramSocket.close();
        }
    }
}