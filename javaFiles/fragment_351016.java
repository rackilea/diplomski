import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;


public class Client
{
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("127.0.0.1", 4000);
        BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;

        writerChannel.write(new Date().toString() + "\n\r");
        writerChannel.flush();

        while ((line = readerChannel.readLine()) != null)
        {
            System.out.println(line);
        }
    }
}