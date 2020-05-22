import java.io.*;
import java.net.*;

class Server implements Runnable {
  public static final int port = 5678;


  public void run() {
    try{
       ServerSocket server = new ServerSocket(port);

       while (true) 
       {
           final Socket client = server.accept();
           new Thread() {
                public void run() {
                      try{
                          ObjectInputStream in = 
                          new ObjectInputStream( client.getInputStream() );
                         String msg = (String) in.readObject();
                         System.out.println(msg);
                        }
                      catch(Exception e){System.err.println(e);}

          }}.start();
       }
      }
    catch(IOException e){System.err.println(e);}
    }

}

class Client {

  public void writeMessage(String msg) throws IOException {
     new ObjectOutputStream((new Socket("localhost",Server.port).getOutputStream())).writeObject(msg);
  }
}

public class ClientServer{
  public static void main(String[] args) throws IOException{
    Server server = new Server("My Multithreaded Server");
    new Thread(server).start();
    Client client1 = new Client();
    Client client2 = new Client();
    client1.writeMessage("Hello !");
    client2.writeMessage("Give me five !");
  }
}