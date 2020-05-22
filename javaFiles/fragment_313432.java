import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSend {


 public static void main(String[] args) throws IOException
  {
      FileInputStream fstream = new FileInputStream("D:/T.txt");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));

      File file = new File("D:/T.txt");
      FileInputStream fis = new FileInputStream(file);
      byte[] fsize = new byte[(int) file.length()];
      int size = fis.read(fsize);
                System.out.println("Size = " + size);



      InetAddress addr = InetAddress.getByName("localhost");
      byte[]  buf  = new byte[10000];

      String DataLine; 
      while ((DataLine = br.readLine()) != null)  
      { 
                DatagramPacket packet =new DatagramPacket(DataLine.getBytes(),         DataLine.length() , addr, 4555);
          System.out.println (DataLine);
          DatagramSocket socket = new DatagramSocket();
          socket.send(packet);

      }//end while loop


  }//end main method 

 }