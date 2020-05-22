import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.DataOutputStream; 
import java.net.URL;             
import javax.net.ssl.HttpsURLConnection;

public class TestHttpsPost {

    public static void main(String[] args) throws Exception {

        // Uncomment one of these next two lines:
        URL url = new URL("https://api.sandbox.paypal.com/v1/payments/payment");
        //URL url = new URL("https://httpbin.org/post"); // good for testing

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        // Change this to a valid token:
        connection.setRequestProperty("Authorization", "Bearer A015mK--1cz4kfmrLwEuxE9VgHIh9IwEqNvUvdlqMAByvjI");
        connection.setRequestProperty("Content-Type", "application/json");
        String jsonData = "{ \"intent\":\"sale\",\"redirect_urls\":{\"return_url\":\"http://example.com/your_redirect_url.html\",\"cancel_url\":\"http://example.com/your_cancel_url.html\"},\"payer\":{\"payment_method\":\"paypal\"},\"transactions\":[{\"amount\":{\"total\":\"7.47\",\"currency\":\"USD\"}}]}";

        try {
            // Post the data:
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            output.writeBytes(jsonData);
            output.close();

            // Read the response:
            BufferedReader reader = new BufferedReader(new InputStreamReader(
              connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Response code:" + connection.getResponseCode());
        System.out.println("Response message:" + connection.getResponseMessage());
    }
}