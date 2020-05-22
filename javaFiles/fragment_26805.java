package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TcpServer {
public static ArrayList<EchoService> connectedServices;

public TcpServer(){
    ServerSocket server = null;
    try{
        server = new ServerSocket(9991);
        System.out.println("server started");
        connectedServices = new ArrayList<>();
        while(!server.isClosed()){
            Socket acceptedSocket = server.accept();
            System.out.println("client connected: " 
            +acceptedSocket.getInetAddress());
            EchoService service = new EchoService(acceptedSocket);
            service.start();

        }
    }catch (IOException e){
        e.printStackTrace();
    } finally {
        if(server!=null) {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public static void main(String[] args){
    new TcpServer();
}

public static void removeConnectedService(EchoService client) {
    boolean removed = connectedServices.remove(client);
    System.out.println("client has been removed"+ 
    client.getAcceptedSocket().getInetAddress()+", "+removed);
}

public static void broadCastMsg(long id, String usrMsg) throws IOException {
    for(EchoService client: connectedServices){
        if(client.getId()!=id)
        {
            String serverMsg = "server broadcast: " + usrMsg;
            client.getOs().writeUTF(serverMsg);
            client.getOs().flush();
        }
    }

}
}