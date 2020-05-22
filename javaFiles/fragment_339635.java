import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;

public class Test {
    public static void main(String[] args) throws IOException {
        URL httpsURL = new URL("https://www.google.com.br/");
        HttpsURLConnection connection = (HttpsURLConnection) httpsURL.openConnection();
        connection.connect();
        Certificate[] certs = connection.getServerCertificates();
        for (Certificate cer : certs) {
            System.out.println(cer.getPublicKey());
        }
    }
}