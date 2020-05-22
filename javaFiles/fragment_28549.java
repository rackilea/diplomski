import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class LineReader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("usage: java LineReader charset url");
            System.exit(1);
        }

        try {
            final String charset = args[0];
            final URI url = new URI(args[1]);
            final String host = url.getHost();
            final int port = url.getPort();
            final Socket socket = new Socket(host, port);
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), charset));
            while (true) {
                final String line = reader.readLine();
                System.out.println(line);
            }
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}