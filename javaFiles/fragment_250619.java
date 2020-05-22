import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Pinger
{
    public static List<String> PingIpAddr(String ip) throws IOException
    {
        ProcessBuilder pb = new ProcessBuilder("ping", ip);
        //ProcessBuilder pb = new ProcessBuilder("ping", "-c 5", ip);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(pb.start().getInputStream()));        

        while (!stdInput.ready())
        {
            // custom timeout handling
        }

        String line;
        ArrayList<String> output = new ArrayList<>();

        while ((line = stdInput.readLine()) != null)
        {
            output.add(line);
        }

        return output;
    }

    public static void main(String[] args) throws IOException
    {
        List<String> lines = Pinger.PingIpAddr("127.0.0.1");

        for (String line : lines)
        {
            System.out.println(line);
        }
    }
}