import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public static void main(String[] args) throws FileNotFoundException, CertificateException {
         FileInputStream fin = new FileInputStream("C://Users/admin/Desktop/uidai_auth_stage.cer");
         CertificateFactory f = CertificateFactory.getInstance("X.509");
         X509Certificate certificate = (X509Certificate)f.generateCertificate(fin);
         PublicKey pk = certificate.getPublicKey();
         System.out.println(pk);
    }