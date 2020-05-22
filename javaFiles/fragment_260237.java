package justtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ipServer = InetAddress.getByName("localhost");
        DatagramSocket datagramSocket = null;
        DatagramSocket datagramSocketA = null;
        DatagramSocket datagramSocketB = null;
        byte[] sendDatagram = new byte[1054];
        byte[] sendDatagramB = new byte[1055];
        byte[] sendDatagramC = new byte[1056];

        byte[] receiveDatagram = new byte[1054];
        byte[] receiveDatagramB = new byte[1055];
        byte[] receiveDatagramC = new byte[1056];

        while (true) 
        {
            System.out.println();
            System.out.println("Ingrese X");
            String msgA = input.readLine();

            //sendDatagram = (msgA.getBytes());
            System.arraycopy(msgA.getBytes(), 0, sendDatagram, 0, msgA.getBytes().length);
            DatagramPacket sendPacket = new DatagramPacket(sendDatagram, sendDatagram.length, ipServer, 6667);
            DatagramPacket recvPacket = new DatagramPacket(sendDatagram, receiveDatagram.length, ipServer, 6667);

            datagramSocket = new DatagramSocket();
            datagramSocket.send(sendPacket);
            datagramSocket.receive(recvPacket);
            System.out.printf("Send...[%s]/ recv...[%s]", new String(sendDatagram).trim(), new String(recvPacket.getData()).trim());


            System.out.println();
            System.out.println("Ingrese B");
            String msgB = input.readLine();
            //sendDatagramB = (msgB.getBytes());
            System.arraycopy(msgB.getBytes(), 0, sendDatagramB, 0, msgB.getBytes().length);
            DatagramPacket sendPacketB = new DatagramPacket(sendDatagramB, sendDatagramB.length, ipServer, 6667);
            DatagramPacket recvPacketB = new DatagramPacket(receiveDatagramB, receiveDatagramB.length, ipServer, 6667);

            datagramSocketA = new DatagramSocket();
            datagramSocketA.send(sendPacketB);
            datagramSocketA.receive(recvPacketB);
            System.out.printf("Send...[%s]/ recv...[%s]", new String(sendDatagramB).trim(), new String(recvPacketB.getData()).trim());


            System.out.println();
            System.out.println("Ingrese C");

            String msgC = input.readLine();
            //sendDatagramC = (msgC.getBytes());
            System.arraycopy(msgC.getBytes(), 0, sendDatagramC, 0, msgC.getBytes().length);
            DatagramPacket sendPacketC = new DatagramPacket(sendDatagramC, sendDatagramC.length, ipServer, 6667);
            DatagramPacket recvPacketC = new DatagramPacket(receiveDatagramC, receiveDatagramC.length, ipServer, 6667);
            datagramSocketB = new DatagramSocket();
            datagramSocketB.send(sendPacketC);
            datagramSocketB.receive(recvPacketC);
            System.out.printf("Send...[%s]/ recv...[%s]", new String(sendDatagramC).trim(), new String(recvPacketC.getData()).trim());

            datagramSocket.close();
            datagramSocketA.close();
            datagramSocketB.close();
        }
    }
}