import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;

public class AcquireTokenByRefreshToken {

    static String tenantId = "***";
    static String username = "***";
    static String password = "***";
    static String clientId = "***";
    static String resource = "https://graph.windows.net";
    static String userEmail = "***";

    public static void main(String[] args) throws MalformedURLException, IOException {
        AuthenticationContext authContext = null;
        AuthenticationResult authResult = null;
        ExecutorService service = null;

        try {
            service = Executors.newFixedThreadPool(1);
            String url = "https://login.microsoftonline.com/" + tenantId + "/oauth2/authorize";
            authContext = new AuthenticationContext(url, false, service);
            Future<AuthenticationResult> future = authContext.acquireToken(resource, clientId, userEmail, password,
                    null);

            authResult = future.get();
            System.out.println("get access token: \n" + authResult.getAccessToken());
            System.out.println("get refresh token: \n" + authResult.getRefreshToken());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // get access token by refresh token
        getToken(authResult.getRefreshToken());
    }

    public static void getToken(String refreshToken) throws IOException {

        String encoding = "UTF-8";
        String params = "client_id=" + clientId + "&refresh_token=" + refreshToken
                + "&grant_type=refresh_token&resource=https%3A%2F%2Fgraph.windows.net";
        String path = "https://login.microsoftonline.com/" + tenantId + "/oauth2/token";
        byte[] data = params.getBytes(encoding);
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));
        conn.setConnectTimeout(5 * 1000);
        OutputStream outStream = conn.getOutputStream();
        outStream.write(data);
        outStream.flush();
        outStream.close();
        System.out.println(conn.getResponseCode());
        System.out.println(conn.getResponseMessage());

        BufferedReader br = null;
        if (conn.getResponseCode() != 200) {
            br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
        } else {
            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        }
        System.out.println("Response body : " + br.readLine());
    }

}