import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {

    public final static int defaultPort = 2345;

    public static void main(String[] args) {
        int port = defaultPort;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
        }
        if (port <= 0 || port >= 65536) {
            port = defaultPort;
        }
        try {
            ServerSocket ss = new ServerSocket(port);

            while (true) {
                try {
                    Socket s = ss.accept();

                    new SocketThread(s).start();
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static class SocketThread extends Thread {

        private Socket s;

        public SocketThread(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                String response = "Hello " + s.getInetAddress() + " on port "
                        + s.getPort() + "\r\n";
                response += "This is " + s.getLocalAddress() + " on port "
                        + s.getLocalPort() + "\r\n";
                OutputStream out = s.getOutputStream();
                out.write(response.getBytes());
                BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                    String line = input.readLine();
                    System.out.println("IN: " + line);
                    s.getOutputStream().write(("ECHO " + line + "\n").getBytes());
                    s.getOutputStream().flush();
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }
}