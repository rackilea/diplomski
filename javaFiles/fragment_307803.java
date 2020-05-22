import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketGetINetAdd {


    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 2345);
        InetAddress inetAddress = socket.getInetAddress();

        System.out.println("Connected to:: " + inetAddress.getHostName() + " Local address:: " + socket.getLocalAddress() + " Local Port:: " + socket.getLocalPort());
        new OutputThread(socket.getInputStream()).start();

        InputStreamReader consoleReader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(consoleReader);
        while (true) {                        
            String inline = in.readLine();
            if (inline.equals("by")) {
                break;
            }
            inline += "\n";
            socket.getOutputStream().write(inline.getBytes());
            socket.getOutputStream().flush();
        }
    }

    public static class OutputThread extends Thread {

        private InputStream inputstream;

        public OutputThread(InputStream inputstream) {
            this.inputstream = inputstream;
        }

        @Override
        public void run() {
            BufferedReader input = new BufferedReader(new InputStreamReader(inputstream));
            while (true) {
                try {
                    String line = input.readLine();
                    System.out.println(line);
                } catch (IOException exception) {
                    exception.printStackTrace();
                    break;
                }
            }
        }

    }
}