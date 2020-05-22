// Client.java (will sleep in CLOSE_WAIT)
import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket(InetAddress.getByName("localhost"), 12345);
        InputStream in = socket.getInputStream();
        int c;
        while ((c = in.read()) != -1)
        {
            System.out.write(c);
        }
        System.out.flush();

        // should now be in CLOSE_WAIT
        Thread.sleep(Integer.MAX_VALUE);
    }
}

// Server.java (sends some data and exits)
import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new ServerSocket(12345).accept();
        OutputStream out = socket.getOutputStream();
        out.write("Hello World\n".getBytes());
        out.flush();
        out.close();
    }
}