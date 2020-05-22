import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class ReadIp{

        public void getIP() throws MalformedURLException, IOException{
             String ip="";
             String nextLine;
           URL url = null;
           URLConnection urlConn = null;
           InputStreamReader  inStream = null;
           BufferedReader buff = null;


              url  = new URL("http://www.whatismyip.org" );
              urlConn = url.openConnection();
             inStream = new InputStreamReader( 
              urlConn.getInputStream());
               buff= new BufferedReader(inStream);


                while ((nextLine =buff.readLine()) !=null){
            System.out.println(nextLine); 
        }

                  }
}