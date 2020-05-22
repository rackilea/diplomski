// xagyg wrote this, but you can copy it
import java.util.*;
import java.io.*;
import java.net.*;

public class ChatClient {


    public static void main(String[] args) throws Exception {

        Socket s = new Socket(args[0], 4444);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message;
        new SocketReader(in).start();   
        while ((message = reader.readLine())!=null) {
            out.println(message);
            out.flush();
            if (message.equals("quit")) break;
        }
        in.close();
        out.close();
    }        
}

class SocketReader extends Thread {

    BufferedReader in;

    public SocketReader(BufferedReader in) {
        this.in = in;
    }

    public void run() {   
        String message;
        try {
            while ((message = in.readLine())!=null) {
                System.out.println(message);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }        
    }
}