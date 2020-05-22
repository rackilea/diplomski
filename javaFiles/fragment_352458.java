import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("Server starts at port:" + port);
        serverSocket = new ServerSocket(port);

        System.out.println("Waiting for client...");
        Socket client = serverSocket.accept();

        sendMessage(client, "This is Hamming Code Checking.");

        boolean checkInput = false;
        String input = null;
        while (!checkInput) {
            input = getMessage(client);

            if (input.length() == 7 && input.matches("[01]+"))
                checkInput = true;
            else
                sendMessage(client, "invalid");
        }
        sendMessage(client, input);
    }

    private void sendMessage(Socket client, String message) throws IOException {
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        writer.println(message);
    }

    private String getMessage(Socket client) throws IOException {
        String userInput;
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        userInput = reader.readLine();
        return userInput;
    }

    public static void main(String[] args) {
        int portNumber = 9987;

        try {
            Server socketServer = new Server(portNumber);
            socketServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}