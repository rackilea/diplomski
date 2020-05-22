package com.mycompany;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.resource.ResourceResolver;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class CxfClientSslTest {

    public static void main(String[] args) {
        try {

            Bus bus = BusFactory.getThreadDefaultBus();
            ResourceManager extension = bus.getExtension(ResourceManager.class);

            extension.addResourceResolver(new ResourceResolver() {
                @Override
                public <T> T resolve(String resourceName, Class<T> resourceType) {
                    System.out.println("resourceName: " + resourceName + " - resourceType: " + resourceType);
                    return null;
                }

                @Override
                public InputStream getAsStream(String name) {
                    try {
                        if (!name.startsWith("https")) {
                            return null;
                        }
                        SSLSocketFactory sslSocketFactory = SslUtil.getSslSocketFactory();
                        SchemeRegistry schemeRegistry = new SchemeRegistry();
                        schemeRegistry.register(new Scheme("https", 8443, sslSocketFactory));

                        final HttpParams httpParams = new BasicHttpParams();
                        DefaultHttpClient httpClient = new DefaultHttpClient(new BasicClientConnectionManager(schemeRegistry), httpParams);

                        HttpGet get = new HttpGet(name);
                        HttpResponse response = httpClient.execute(get);
                        return response.getEntity().getContent();
                    } catch (Exception e) {
                        return null;
                    }
                }
            });

            QName SERVICE_NAME = new QName("http://server/schemas/services", "MyService");
            URL wsdlURL = new URL("https://localhost:8443/services/MyService?wsdl");
            MyService ss = new MyService(wsdlURL, SERVICE_NAME);
            MyServicePortType port = ss.getMyServicePort();

            tslIt(port);

            IdHolder mensagem = new IdHolder();
            mensagem.setId(1L);
            MyDataObject dataObject = port.getById(mensagem);

            System.out.println("Id: " + dataObject.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tslIt(MyServicePortType port) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException,
            UnrecoverableKeyException {
        Client client = ClientProxy.getClient(port);
        HTTPConduit http = (HTTPConduit) client.getConduit();

        TLSClientParameters tlsClientParameters = http.getTlsClientParameters();

        KeyStore keyStore = getKeyStore();
        KeyStore trustStore = getTrustStore();

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());

        keyManagerFactory.init(keyStore, "123456".toCharArray());
        KeyManager[] keyMgrs = keyManagerFactory.getKeyManagers();
        tlsClientParameters.setKeyManagers(keyMgrs);

        trustManagerFactory.init(trustStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        tlsClientParameters.setTrustManagers(trustManagers);

        tlsClientParameters.setDisableCNCheck(true);
    }

    public static KeyStore getKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        URL keyStoreUrl = CxfClientSslTest.class.getResource("/certs/client.jks");
        File keystoreFile = new File(keyStoreUrl.getPath());
        if (!keystoreFile.exists()) {
            throw new RuntimeException("keystore doesn't exists: " + keystoreFile.getAbsolutePath());
        }

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream keystoreInput = new FileInputStream(keystoreFile.getAbsolutePath());
        keystore.load(keystoreInput, "changeit".toCharArray());
        keystoreInput.close();
        return keystore;
    }

    public static KeyStore getTrustStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        URL trustStoreUrl = CxfClientSslTest.class.getResource("/certs/client-trust.jks");
        File trustStoreFile = new File(trustStoreUrl.getPath());
        if (!trustStoreFile.exists()) {
            throw new RuntimeException("truststore doesn't exists: " + trustStoreFile.getAbsolutePath());
        }

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream trustStoreInput = new FileInputStream(trustStoreFile.getAbsolutePath());
        trustStore.load(trustStoreInput, "changeit".toCharArray());
        trustStoreInput.close();
        return trustStore;
    }
}