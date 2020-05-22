import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class HttpClientFactory {

    private static CloseableHttpClient client;

    private HttpClientFactory() {
    }

    public static HttpClient getHttpsClient(SslUtils sslUtils, int timeout) throws Exception {

        if (client != null) {
            return client;
        }

        SSLContext sslcontext = getSSLContext(sslUtils);
        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslcontext, new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.addInterceptorFirst(new ContentLengthHeaderRemover());
        RequestConfig config = RequestConfig.custom()
                                    .setConnectTimeout(timeout)
                                    .setConnectionRequestTimeout(timeout)
                                    .setSocketTimeout(timeout)
                                    .build();

        return httpClientBuilder.setSSLSocketFactory(factory)
                    .setDefaultRequestConfig(config)
                    .build();
    }

    private static class ContentLengthHeaderRemover implements HttpRequestInterceptor {
        @Override
        public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
            request.removeHeaders(HTTP.CONTENT_LEN);
        }
    }

    public static void releaseInstance() {
        client = null;
    }

    private static SSLContext getSSLContext(SslUtils sslUtils) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, KeyManagementException {

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(sslUtils.getKeystore().getInputStream(), sslUtils.getKeyPwd().toCharArray());
        sslUtils.getKeystore().getInputStream().close();

        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(sslUtils.getTrustStore().getInputStream(), sslUtils.getTrustPwd().toCharArray());
        sslUtils.getTrustStore().getInputStream().close();

        SSLContextBuilder sslContextBuilder = SSLContexts.custom();
        try {
            sslContextBuilder = SSLContexts.custom().loadKeyMaterial(ks, ssl.getKeyPwd().toCharArray());
        } catch (UnrecoverableKeyException e) {
            e.printStack();
        }
        sslContextBuilder.loadTrustMaterial(ts, new TrustSelfSignedStrategy());
        return sslContextBuilder.build();
    }
}