import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.security.KeyManagementException;
    import java.security.KeyStoreException;
    import java.security.NoSuchAlgorithmException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    import javax.net.ssl.SSLContext;

    import org.apache.http.Header;
    import org.apache.http.HttpEntity;
    import org.apache.http.NameValuePair;
    import org.apache.http.client.ClientProtocolException;
    import org.apache.http.client.entity.UrlEncodedFormEntity;
    import org.apache.http.client.methods.CloseableHttpResponse;
    import org.apache.http.client.methods.HttpGet;
    import org.apache.http.client.methods.HttpPost;
    import org.apache.http.conn.ssl.NoopHostnameVerifier;
    import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
    import org.apache.http.impl.client.CloseableHttpClient;
    import org.apache.http.impl.client.HttpClients;
    import org.apache.http.impl.client.LaxRedirectStrategy;
    import org.apache.http.message.BasicNameValuePair;
    import org.apache.http.ssl.SSLContexts;
    import org.apache.http.util.EntityUtils;

    public class ApacheHttpClient {


    public static void main(String[] args) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial((chain, authType) -> true).build();

        SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext, new String[]
                {"SSLv2Hello", "SSLv3", "TLSv1","TLSv1.1", "TLSv1.2" }, null,
                NoopHostnameVerifier.INSTANCE);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();
         try {

             HttpPost httpPost = new HttpPost("url/login");
             List <NameValuePair> nvps = new ArrayList <NameValuePair>();
             nvps.add(new BasicNameValuePair("IDToken1", name));
             nvps.add(new BasicNameValuePair("IDToken2", password));
             httpPost.setEntity(new UrlEncodedFormEntity(nvps));
             CloseableHttpResponse response2 = httpclient.execute(httpPost);

             try {
                 System.out.println("Status -->>> "+ response2.getStatusLine().getStatusCode());

                 Header[] cookieInf = response2.getHeaders("Set-Cookie");
                 StringBuilder strBf = new StringBuilder();
                 for(Header header : cookieInf)
                 {
                     strBf.append(header.getValue());
                 }
                 System.out.println("Data is "+ strBf);
                 HttpEntity entity2 = response2.getEntity();


                 // do something useful with the response body
                 // and ensure it is fully consumed
                 EntityUtils.consume(entity2);

             } finally {
                 response2.close();
             }
         } finally {
             httpclient.close();
         }
    }

    }