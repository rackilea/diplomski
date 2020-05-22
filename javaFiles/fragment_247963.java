import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;

    Server() {
        try {
            serverSocket = new ServerSocket(2222);
        } catch (IOException e) {
            System.out.println("IOException in Server Constructor");
        }
    }

    public void operate() {
        try {
            // Control control = new Control();
            socket = serverSocket.accept();
            while (true) {
                System.out.println("Server starts listening on "
                        + serverSocket.getLocalPort());

                System.out.println("Server accepts connection.");

                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                pw.println("Hi Client");

//              Thread.sleep(1000);
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                System.out.println(br.readLine());
                System.out.println("reply sent to client");
                // control.recieve(socket, br.readLine());
            }
        } catch (IOException /*| InterruptedException*/ e) {
            System.out.println("IOException in Server operate function");
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.operate();
    }

}