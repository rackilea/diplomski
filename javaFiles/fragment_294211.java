import java.net.*;
import java.io.*;

public class NewsTask implements Runnable {
  @Override
  public void run() {
    URL oracle = new URL("https://news.google.co.uk/");
    URLConnection yc = oracle.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    String inputLine;

    while ((inputLine = in.readLine()) != null) 
       System.out.println(inputLine);
    in.close();
  }
}