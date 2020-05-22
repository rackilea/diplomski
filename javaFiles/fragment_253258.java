import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
      while(true) {
         try{
         DatagramSocket clientSocket = new DatagramSocket();
         InetAddress IPAddress = InetAddress.getByName("localhost");
         byte[] sendData = new byte[100];
         byte[] receiveData = new byte[100];
         String sentence = "Hello Server!";
         sendData = sentence.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
         clientSocket.send(sendPacket);
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         clientSocket.receive(receivePacket);
         String modifiedSentence = new String(receivePacket.getData());
         System.out.println("FROM SERVER:" + modifiedSentence);
         clientSocket.close();
         }
         catch (PortUnreachableException pe)
         {
           System.out.println("COULDN'T CONNECT TO SERVER:" + pe.getMessage());
         }
         catch (Exception ex)
         {
           System.out.println("COULDN'T CONNECT TO SERVER:" + ex.getMessage());
         }
         Thread.sleep(2000);
      }

   }
}