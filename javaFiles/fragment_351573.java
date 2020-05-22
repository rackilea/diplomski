import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.jboss.util.Base64;

public class test9 {

public static void main(String[] args) {
    URL url;
    URLConnection urlConn = null;
    HttpURLConnection htcon = null;
    InputStream is = null;
    StringBuffer sb = new StringBuffer();
    String authStr = "apikey:password";

    String authStringEnc = Base64.encodeBytes(authStr.getBytes());

    //String authStringEnc = new String(Base64Encoder.encode(authString.getBytes()));
    try {
        url = new URL("https:go-frugal.myshopify.com/admin/orders.json");
        urlConn = url.openConnection();
        urlConn.setRequestProperty("Authorization", "Basic " +  authStringEnc);
        urlConn.setRequestMethod("GET");
                urlConn.setRequestProperty("user-agent","Mozilla/5.0");
                urlConn.setRequestProperty("Content-Type","application/json");

        htcon = (HttpURLConnection) urlConn;
        is = htcon.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        int numCharsRead;
        char[] charArray = new char[1024];

        while ((numCharsRead = isr.read(charArray)) > 0) {
            sb.append(charArray, 0, numCharsRead);
        }   

        System.out.println("sb: "+sb);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}