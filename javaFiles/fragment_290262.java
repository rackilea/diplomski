import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class X509PrincipalSample {

    public static void main(String[] args) throws Exception {

            CertificateFactory cf = CertificateFactory.getInstance("X509");
            // certificate file must be encoded in DER binary format
            FileInputStream certificateFile = new FileInputStream("/tmp/cer.cer");
            X509Certificate certificate = (X509Certificate) cf.generateCertificate(certificateFile);
            X509Principal x509Principal = PrincipalUtil.getSubjectX509Principal(certificate);
            System.out.println(x509Principal.getName());
    }
}