import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Sample {

    public static void main(String[] args) throws Exception {

        // generate your certificate
        CertificateFactory cf = CertificateFactory.getInstance("X509", new BouncyCastleProvider());
        Certificate yourCert = cf.generateCertificate(new FileInputStream("C:/your_certificate_path"));
        // here you can add also the issuer of your cert
        Certificate[] certChain = { yourCert };
        // depending on your private key format you've a different
        // ways to parse its
        Key privatekey = null;//...
        String alias = "yourKSEntry";
        // generate the keystore
        KeyStore ks = KeyStore.getInstance("PKCS12", new BouncyCastleProvider());
        // necessary to init a new keystore
        ks.load(null, null);
        String keyPass = null;// your key pass or null if the key file has no password
        // adds the key and cert to the keystore
        ks.setKeyEntry(alias, privatekey, null, certChain);
        // save to file in order that then you
        // can install on windows keystore
        ks.store(new FileOutputStream("C:/where_save_your_keystore.p12"), "your_keystore_pass".toCharArray());

    }
}