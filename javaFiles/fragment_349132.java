import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

       public class Test {
          private static String ENDPOINT ="http://wisekar.iitd.ernet.in/active/api_resources.php/method/mynode";
          public static void main(String[] args) throws IOException 
          { 
              String url = ENDPOINT;
              String charset = "UTF-8";
              String param1 = "mykey";

              String query = String.format("key=%s", 
                   URLEncoder.encode(param1, charset));
              java.net.URLConnection connection = new URL(url + "?" + query).openConnection();
              connection.setRequestProperty("Accept-Charset", charset);
              if ( connection instanceof HttpURLConnection)
              {
                 HttpURLConnection httpConnection = (HttpURLConnection) connection;
                 System.out.println(httpConnection.getResponseCode());
                 System.out.println(httpConnection.getResponseMessage());
              }
              else
              {
                 System.err.println ("error!");
              }
          }
   }