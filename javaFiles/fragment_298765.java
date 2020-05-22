import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) throws Exception{

      URL url = new URL("http://localhost:8080/js/txt1.txt");
        // read text
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
        while ((line = in.readLine()) != null) {
        System.out.println(line);
    }
    in.close();
    }
}