import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
    public static void main(String[] args) {   
        System.setProperty("https.protocols", "TLSv1,SSLv3,SSLv2Hello");
        System.setProperty("javax.net.debug", "all");

        try{
            String httpsURL = "https://sikuani.udea.edu.co:4443";
            URL myurl = new URL(httpsURL);
            HttpURLConnection con = (HttpURLConnection)myurl.openConnection();
            InputStream ins = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(ins);
            BufferedReader in = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = in.readLine()) != null) {   
                System.out.println(inputLine);
            }   

            in.close();
        }
        catch(Exception ex){

        }
    } 
}