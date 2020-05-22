import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;


if (this.certificateList!=null) {
     org.bouncycastle.asn1.x509.Certificate certificate = certificateList[0];
     X509CertificateHolder holder = new X509CertificateHolder(certificate.getEncoded());
     X509Certificate x509Certificate = new JcaX509CertificateConverter().getCertificate(holder);
     Collection<List<?>> sanCollections = x509Certificate.getSubjectAlternativeNames();
}