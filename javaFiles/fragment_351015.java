import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket listener = new ServerSocket(4000);
        String line;
        try
        {
            while (true)
            {
                Socket socket = listener.accept();
                BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                try
                {
                    writerChannel.write(new Date().toString() + "\n\r");
                    writerChannel.flush();

                    while ((line = readerChannel.readLine()) != null)
                    {
                        System.out.println(line);
                    }
                }
                finally
                {
                    socket.close();
                }
            }
        }
        finally
        {
            listener.close();
        }
    }
}