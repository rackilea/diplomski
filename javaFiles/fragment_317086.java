import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Test
{

    public static void main(String[] args) throws Exception
    {
        URL url = new URL("https://www.google.com");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        Map<String,List<String>> fields = con.getHeaderFields();
        con.disconnect();
    }
}