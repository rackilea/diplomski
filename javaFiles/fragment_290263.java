import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;


public class X500NameSample {

    public static void main(String[] args) throws Exception {

         CertificateFactory cf = CertificateFactory.getInstance("X509");
         // certificate file must be encoded in DER binary format
         FileInputStream certificateFile = new FileInputStream("C:/Documents and Settings/aciffone/Escritorio/cer.cer");
         X509Certificate certificate = (X509Certificate) cf.generateCertificate(certificateFile);

         // using X500Principal
         X500Principal subjectX500Principal = certificate.getSubjectX500Principal();
         System.out.println(subjectX500Principal.getName());
         System.out.println(subjectX500Principal.getName(X500Principal.RFC1779));
         System.out.println(subjectX500Principal.getName(X500Principal.CANONICAL));

         // using X500Name
         X500Name x500name = new X500Name( subjectX500Principal.getName(X500Principal.RFC1779) );
         // you can get the different subject DN values with BCStyle constants
         RDN cn = x500name.getRDNs(BCStyle.CN)[0];
         System.out.println(IETFUtils.valueToString(cn.getFirst().getValue()));

         x500name = new X500Name( subjectX500Principal.getName() );
         // you can get the different subject DN values with BCStyle constants
         cn = x500name.getRDNs(BCStyle.CN)[0];
         System.out.println(IETFUtils.valueToString(cn.getFirst().getValue()));
    }
}