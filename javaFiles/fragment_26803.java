public class TcpServer {

public TcpServer(){
    ServerSocket server = null;
    try{
        server = new ServerSocket(9991);
        while(!server.isClosed()){
            Socket acceptedSocket = server.accept();
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
}}