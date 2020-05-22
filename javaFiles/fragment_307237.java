import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.stream.Stream;

public class CustomHttpsSSLConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomHttpsSSLConfig.class);
    private static final String PROD_INSTANCE = "prod";
    private static final String STG_INSTANCE1 = "staging";
    private static final String STG_INSTANCE2 = "stg";
    private static final String QA_INSTANCE   = "qa";
    private static final String DEV_INSTANCE  = "dev";
    public static void init(String instance, String hostnameVerification, String trustweaverKeystore, String trustweaverKeystoreType, String trustweaverKeystorePassword, String trustweaverCATrustStore, String trustweaverCATrustStoreType, String trustweaverCATrustStorePassword) {

        // Install the all-trusting trust manager
        try {
            // Client keystore
            KeyStore keyStore = KeyStore.getInstance(trustweaverKeystoreType);
            keyStore.load(new FileInputStream(trustweaverKeystore), trustweaverKeystorePassword.toCharArray());

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, trustweaverKeystorePassword.toCharArray());

            // Trusted CA keystore
            KeyStore truststore = KeyStore.getInstance(trustweaverCATrustStoreType);
            truststore.load(new FileInputStream(trustweaverCATrustStore), trustweaverCATrustStorePassword.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(truststore);

            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(getHostnameVerifierForInstance(instance,hostnameVerification));
            LOGGER.info("Initialized CustomHttpsSSLConfig with keyStore = {}, truststore = {}",trustweaverKeystore,trustweaverCATrustStore);
        } catch (Exception e) {
            LOGGER.error("CustomHttpsSSLConfig Initialization failed with keyStore = {}, truststore = {}, exception = {}, stacktrace = {} ",trustweaverKeystore,trustweaverCATrustStore,e.getMessage(),e.getStackTrace());
        }
    }

    private static HostnameVerifier getHostnameVerifierForInstance(String instance,String enabled){
        return Boolean.parseBoolean(enabled)&&reject(instance) ? customHostnameVerifier() : permitAll();
    }

    private static boolean reject(String instance) {
        return rejections().anyMatch(instance.trim().toLowerCase()::startsWith);
    }

    private static Stream<String> rejections() {
        return Stream.of(PROD_INSTANCE, STG_INSTANCE1,STG_INSTANCE2, QA_INSTANCE, DEV_INSTANCE).map(String::toLowerCase);
    }

    private static HostnameVerifier customHostnameVerifier() {
         return new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                DefaultHostnameVerifier verifier = new DefaultHostnameVerifier();
                return verifier.verify(hostname, session);
            }
        };
    }

    private static HostnameVerifier permitAll() {
        return (hostname, session) -> true;
    }
}