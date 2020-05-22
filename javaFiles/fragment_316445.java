import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

public class HTTPTestClient {

    public static void main(String[] args) throws Exception {
        String url = "https://localhost:9443/wso2/scim/Users";
        BasicCookieStore cookieStore = new BasicCookieStore();

        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "admin");

        SSLContextBuilder builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
        CloseableHttpClient httpclient = HttpClientBuilder.create().setSSLSocketFactory(sslsf)
                .setDefaultCookieStore(cookieStore).build();

        HttpGet get = new HttpGet(url);
        get.addHeader("Accept", "application/json");
        get.addHeader("charset", "UTF-8");
        get.addHeader("Content-Type", "application/json");

        Header header = new BasicScheme().authenticate(credentials, get);
        get.addHeader(header);

        HttpResponse response = httpclient.execute(get);
        System.out.println(response.getStatusLine());
        System.out.println("Response Code : " + response);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result);

    }
}