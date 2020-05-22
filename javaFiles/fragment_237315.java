import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL yahoo = new URL("http://yourhost.com/index.jsp");
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine, data = "";

        while ((inputLine = in.readLine()) != null) 
            data += inputLine;
        in.close();
    }
}