package so52712250;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket sSock = new ServerSocket(1201);
            Socket sock = sSock.accept();

            DataInputStream din = new DataInputStream(sock.getInputStream());
            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "";
            String msgout = "";

            while (!msgin.equals("end")) {
                msgin = din.readUTF();
                System.out.println(msgin);
                msgout = reader.readLine();
                dout.writeUTF("Server: " + msgout);
                dout.flush();
            }
            System.out.println("ended");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}