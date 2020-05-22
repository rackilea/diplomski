// xagyg wrote this, but you can copy it
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    public static List list = new ArrayList();

    public static void main(String[] args) throws Exception {

        ServerSocket svr = new ServerSocket(4444);

        System.out.println("Chat Server started!");

        while (true) {
            try {
                Socket s = svr.accept();
                synchronized(list) {
                   list.add(s);              
                }                                  
                new Handler(s, list).start();
            }
            catch (IOException e) {
                // print out the error, but continue!
                System.err.println(e);
            }
        }
    }
}

class Handler extends Thread {

    private Socket s;
    private String ipaddress;
    private List list;

    Handler (Socket s, List list) throws Exception {
      this.s = s;
      ipaddress = s.getInetAddress().toString();
      this.list = list;
    }

    public void run () {

      try {

        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String message;
        //MyDialog x = (MyDialog)map.get(ipaddress.substring(1));
        while ((message = reader.readLine()) != null) {
            if (message.equals("quit")) {
                synchronized(list) {
                    list.remove(s);
                }
                break;
            }
            synchronized(list) {
                for (Object object: list) {
                    Socket socket = (Socket)object;
                    if (socket==s) continue;
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    writer.println(ipaddress + ": " + message);
                    writer.flush();
                }
            }
        }
        try { reader.close(); } catch (Exception e) {}
      }
      catch (Exception e) {
        System.err.println(e);
      }
    }
}