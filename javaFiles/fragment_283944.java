import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;

public class SimpleServerClient {
    private static final int PORT = 9001;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                SimpleServer server = new SimpleServer(PORT, "Server", false);
                SimpleClient client = new SimpleClient(PORT, "Client", true);
                server.createGui();
                client.createGui();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}