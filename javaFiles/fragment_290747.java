import java.net.URL;
import java.net.HttpURLConnection;
import java.io.OutputStream;

public class GcmPostMe {
    public static void main (String[] args) {

        String data = "{\"to\":\" *** censored recipient token *** \"}";
        String type = "application/json";
        try {
            URL u = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty( "Authorization", "key=" + " *** censored api key *** " );
            conn.setRequestProperty( "Content-Type", type );
            conn.setRequestProperty( "Content-Length", String.valueOf(data.length()));
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            System.out.println(conn.getResponseCode() + " " + conn.getResponseMessage() );
            conn.disconnect();
        } catch (Exception e) {
            System.err.println("Something went wrong");
        }
    }
}