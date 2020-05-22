import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            //connection
            ServerSocket srvr = new ServerSocket(7654);
            Socket skt = srvr.accept();
            System.out.println(skt.getPort());

            BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));

            String msg = "";
            while ((msg = in.readLine()) != null) {
                System.out.println("Received: " + msg);
            } //end of read from client in while loop
            srvr.close();
        } catch (Exception e) {
            System.out.println("Error caught: " + e);
        }

    } // end of main
} // end of class