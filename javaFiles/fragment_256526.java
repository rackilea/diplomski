import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPost {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String postUrl = "https://connect.clickatell.com/[AuthenticationToken]";

            try {
                String tStatus = "";
                URL url = new URL(postUrl + "&XML=<clickatellsdk><action>get_list_country</action></clickatellsdk>");

                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                String line;
                while ((line = br.readLine()) != null)
                {
                    tStatus = line;
                    System.out.println(tStatus);
                }

            } catch (Exception e)
            {
                //Handle Exception
            }

    }

}