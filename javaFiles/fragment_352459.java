import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private String hostname;
    private int port;
    Socket socketClient;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException {
        System.out.println("Attempting to connect to " + hostname + ":" + port);
        socketClient = new Socket(hostname, port);
        System.out.println("\nConnection Established.");
    }

    public void readResponse() throws IOException {
        String userInput;
        BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        System.out.print("Response from server: ");
        userInput = reader.readLine();
        System.out.println(userInput);
    }

    public void sendData() throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(socketClient.getOutputStream(), true);
        System.out.println("Enter a 7-bits binary as message to server:\n");
        String input = sc.nextLine();
        writer.println(input);
    }

    public static void main(String arg[]) {
        Client client = new Client("localhost", 9987);
        try {
            client.connect();
            client.readResponse();
            client.sendData();
            client.readResponse();
        } catch (UnknownHostException e) {
            System.err.println("Host unknown. Cannot establish connection");
        } catch (IOException e) {
            System.err.println("Cannot establish connection. Server may not be up." + e.getMessage());
        }
    }
}