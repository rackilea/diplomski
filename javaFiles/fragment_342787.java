// for TLSv1.2 add: 
import org.apache.http.config.Registry; 
import org.apache.http.config.RegistryBuilder; 
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException; 
import org.apache.http.ssl.SSLContexts;  

    //Set the https use TLSv1.2
    private static Registry<ConnectionSocketFactory> getRegistry() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = SSLContexts.custom().build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                new String[]{"TLSv1.2"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        return RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.getSocketFactory())
            .register("https", sslConnectionSocketFactory)
            .build();
    }

   // for TLSv1.2 use:  
   PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(getRegistry());
   clientConnectionManager.setMaxTotal(100);
   clientConnectionManager.setDefaultMaxPerRoute(20);
   HttpClient client = HttpClients.custom().setConnectionManager(clientConnectionManager).build();