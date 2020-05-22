import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketThread extends Thread {
    static final int SocketServerPORT = 6789;
    ServerSocket serverSocket;

    @Override
    public void run() {
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(SocketServerPORT);
            while (true) {
                socket = serverSocket.accept();
                new FileSaveThread().execute(socket);
            }
        }
        catch (IOException e) { }
        finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) { }
            }
        }
    }

    protected void onDestroy() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            }
            catch (IOException e) { }
        }
    }
}