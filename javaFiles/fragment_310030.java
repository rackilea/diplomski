package javadaemon;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
public static void main(String [] args) {
    try {
        System.out.println("Connecting to " + "127.0.0.1"
                            + " on port " + 9879);
        Socket client = new Socket("127.0.0.1", 9879);
        System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);

        for(int i=0; i<100; i++ ) {
            out.writeUTF("Syn "+i);
        }
        out.flush();
        try {
             Thread.sleep(1000L);
        } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    } catch(IOException e) {
        e.printStackTrace();
    }
}
}