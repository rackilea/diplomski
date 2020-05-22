import java.net.*;
import java.io.*;

class Client {
    public static void main(String args[]) throws Exception {        
        System.out.println("client> started.");
        Socket s = new Socket("localhost", 23456);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        // all messages must end with two linefeeds.
        br.write("hello, world!\n\n");
        // two linefeeds with no messages indicates end.
        br.write("\n\n");

        // see part 7. closing the stream flushes the output.
        br.close();
    }
}

class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket ser = null;
        Socket s = null;
        BufferedReader br = null;
        String str = null;

        System.out.println("server> started");
        ser = new ServerSocket(23456);
        s = ser.accept();
        System.out.println("server> we get signal.");                
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while ((str = br.readLine()) != null) {
            if (str.isEmpty()) {
                System.out.println("server> everything is received.");
                break;
            }
            System.out.println("server> got message: " + str);
        }
        System.out.println("server> done.");
    }
}