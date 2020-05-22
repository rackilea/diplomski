package at.rovo.test.httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Client 
{
    public static void main(String[] args) throws Exception 
    {
        CloseableHttpClient httpClient;

        // SSL setup
        KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream instream = new FileInputStream(new File(Client.class.getResource("/clientTrust.jks").toURI()));
        try 
        {
            trustStore.load(instream, "truststorePW".toCharArray());
        } 
        finally 
        {
            instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(trustStore)
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);


        HttpHost targetHost = new HttpHost("localhost", 8443, "https");

        // Basic Auth setup
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new UsernamePasswordCredentials("root", "passw0rd"));
        httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        try
        {
            HttpGet httpget = new HttpGet("https://localhost:8443/process");

            System.out.println("executing request: " + httpget.getRequestLine());
            System.out.println("to target: " + targetHost);

            CloseableHttpResponse response = httpClient.execute(httpget);
            try
            {
                HttpEntity entity = response.getEntity();

                System.out.println("--------------------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null)
                {
                    System.out.println("Response content length: "+entity.getContentLength());
                }
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line;
                while ((line = rd.readLine()) != null) 
                {
                    System.out.println(line);
                }
                EntityUtils.consume(entity);
            }
            finally
            {
                response.close();
            }
        }
        finally
        {
            httpClient.close();
        }
    }
}