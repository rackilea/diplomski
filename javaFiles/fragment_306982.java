package tivotelnettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Tivo {

    private static final int PORT = 31339;

    private Socket pingSocket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public void connect(){
        try {
            pingSocket = new Socket("192.168.0.10", PORT);
            out = new PrintWriter(pingSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error connecting: " + e.getMessage());
        }
        System.out.println("Connected");
    }

    public void disconnect() throws IOException {
        out.close();
        in.close();
        pingSocket.close();
    }

    public void sendCommand(String command) throws IOException {
        command = command.toUpperCase().trim();
        System.out.println("Sending command: " + command);

        out.println(command);
        System.out.println("Response: " + in.readLine());   
    }
}