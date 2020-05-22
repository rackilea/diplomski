import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client{

   public static void main(String[] args){

      new Client().pingUpdate();
   }

   public void pingUpdate(){

      Thread pingThread = new Thread(){

         @Override
         public void run(){

            while(true){
               Socket ping_socket = null;
               ObjectOutputStream ping_objectOutputStream = null;
               try{
                  ping_socket = new Socket("localhost",
                                           11111);
                  ping_objectOutputStream = new ObjectOutputStream(ping_socket.getOutputStream());

                  ping_objectOutputStream.writeObject("Hallo, Server");
                  ping_objectOutputStream.flush();
               }
               catch(Exception exception){
                  exception.printStackTrace();
               }
               finally{
                  try{
                     if (ping_objectOutputStream != null){
                        ping_objectOutputStream.close();
                     }
                  }
                  catch(IOException e){
                     e.printStackTrace();
                  }
                  try{
                     if (ping_socket != null){
                        ping_socket.close();
                     }
                  }
                  catch(IOException e){
                     e.printStackTrace();
                  }
               }

               // wait some time for the next ping
               try{
                  Thread.sleep(1000);
               }
               catch(InterruptedException e){
                  e.printStackTrace();
               }
            }
         }
      };
      pingThread.start();
   }
}