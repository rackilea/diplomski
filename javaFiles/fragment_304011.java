import java.net.*;
import java.io.*;

public class RequestURI {

    public static void main(String[] args) {
        int port = 8181;
        long startTime = System.currentTimeMillis();
        try {
//            System.getProperties().setProperty("http.proxyHost", "abcd");
//            System.getProperties().setProperty("http.proxyPort", Integer.toString(port));

            URL url = new URL("http://google.com");
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            int resp = uc.getResponseCode();
            if (resp != 200) {
                throw new RuntimeException("Failed: Fragment is being passed as part of the RequestURI");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Run time in ms ="+ (System.currentTimeMillis() - startTime));
    }
}