public class SocketListener extends Service {

    public void sendMessage(String message){
        socket.emit("match", message);
    }
}