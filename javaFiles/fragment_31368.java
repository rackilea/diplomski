import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NewConnectionListener implements Runnable{

public static ServerSocket serverSocket;


public NewConnectionListener(){
    try {
        serverSocket = new ServerSocket(500);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Override
public void run() {

    while(true){
        try {
            Socket s = serverSocket.accept();
            callMethodWithNewSocket(s);
            System.out.println("new Client");
        } catch (IOException e) {
            System.out.println("Error getting Client");
            e.printStackTrace();
        }



    }

}