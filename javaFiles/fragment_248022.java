import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

   public void servePingUpdate(){

      Thread pingThread = new Thread(){

         @Override
         public void run(){

            ServerSocket serverSock = null;
            try{
               serverSock = new ServerSocket(11111);

               while(true){
                  Socket client = null;
                  ObjectInputStream ois = null;

                  try{
                     System.out.println("Server Listening");

                     client = serverSock.accept();
                     System.out.println("Accepted");

                     InputStream inputStream = client.getInputStream();

                     System.out.println("Input stream established");

                     ois = new ObjectInputStream(inputStream);

                     System.out.println("Object streams established");

                     String message = (String) ois.readObject();

                     System.out.println("Object read: " + message);
                  }
                  catch(Exception e){
                     e.printStackTrace();
                  }
                  finally{
                     try{
                        if (ois != null){
                           ois.close();
                        }
                     }
                     catch(IOException e){
                        e.printStackTrace();
                     }
                     try{
                        if (client != null){
                           client.close();
                        }
                     }
                     catch(IOException e){
                        e.printStackTrace();
                     }
                  }
               }
            }
            catch(IOException e1){
               e1.printStackTrace();
            }
            finally{
               try{
                  if (serverSock != null){
                     serverSock.close();
                  }
               }
               catch(IOException e){
                  e.printStackTrace();
               }
            }
         }
      };
      pingThread.start();
   }

   public static void main(String[] args){

      new Server().servePingUpdate();
   }
}