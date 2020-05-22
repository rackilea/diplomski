import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class SimpleHTTPRequest {

  /**
   * @param args
   */
  public static void main(String[] args) {
      HttpURLConnection connection = null;
      DataOutputStream wr = null;
      BufferedReader rd  = null;
      StringBuilder sb = null;
      String line = null;

      URL serverAddress = null;

      try {
          serverAddress = new URL("http://www.google.com/search?q=test");
          //set up out communications stuff
          connection = null;

          //Set up the initial connection
          connection = (HttpURLConnection)serverAddress.openConnection();
          connection.setRequestMethod("GET");
          connection.setDoOutput(true);
          connection.setDoInput(true);
          connection.setUseCaches(false);
          connection.setRequestProperty ( "Content-type","text/xml" ); 
          connection.setAllowUserInteraction(false);
          String strData = URLEncoder.encode("test","UTF-8");
          connection.setRequestProperty ( "Content-length", "" + strData.length ());  
          connection.setReadTimeout(10000);
          connection.connect();

          //get the output stream writer and write the output to the server
          //not needed in this example
          wr = new DataOutputStream(connection.getOutputStream());
          wr.writeBytes("q="+strData);
          wr.flush();

          //read the result from the server
          rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          sb = new StringBuilder();

          while ((line = rd.readLine()) != null)
          {
              sb.append(line + '\n');
          }

          System.out.println(sb.toString());

      } catch (MalformedURLException e) {
          e.printStackTrace();
      } catch (ProtocolException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
      finally
      {
          //close the connection, set all objects to null
          connection.disconnect();
          rd = null;
          sb = null;
          wr = null;
          connection = null;
      }
  }
}