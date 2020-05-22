import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientStringa {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 5555);
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
//            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Random r = new Random();
            int N = r.nextInt(100);
            for(int i=1;i<=N;i++){
//                out.println("String" +i);
                out.writeUTF("String" +i);
            }
            out.flush();
            out.close();
        }
        catch (IOException ex) {
            Logger.getLogger(ClientStringa.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }
}