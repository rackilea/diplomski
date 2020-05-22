package tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Connection {
    // Servers array
    private static final String[] server = { "10.201.30.200", "10.66.20.70" };
    // @logoff: default Telnet port
    private static final int port = 23;

    public static void telnet(String[] server) {
        PrintStream out2;
        try {

            out2 = new PrintStream(new FileOutputStream("output.txt"));

            String[] hrnc = { "HRNC01_", "HRNC02_", "HRNC03_", "NRNC01_",
                    "NRNC02_" };

            for (int i = 0; i < server.length; i++) {
                try {
                    // @logoff: try connection
                    Socket socket = new Socket(server[i], port);
                } catch (IOException e) {
                    // @logoff: typical "Connection timed out" or
                    // "Connection refused"
                    System.err.println("Error connecting to " + server[i]
                            + ". Error = " + e.getMessage());
                    // @logoff: continue to next for element
                    continue;
                }

                // Connect to the specified server
                if (server[i].equals("10.201.30.200")) {
                    // Commands via telnet
                }

                else if (server[i].equals("10.66.20.70")) {
                    // Commands
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // @logoff: your method returns void
        return;
    }

    public static void main(String[] args) {
        telnet(server);
    }
}