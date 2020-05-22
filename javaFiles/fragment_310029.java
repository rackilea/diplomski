package javadaemon;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class MyDaemon {
    public static void main(String [] args) throws IOException {
            ServerSocket ss = new ServerSocket(9879);
            ss.setSoTimeout(0);
        while(true) {
            Socket s = ss.accept();
            System.out.println("socket is connected? "+s.isConnected());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            System.out.println("Input stream has "+dis.available()+" bytes available");
            while(true) {
                try {
                    System.out.println(dis.readByte());
                } catch (Exception e) {
                    break;
                }
            }
        }
    }
}