import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

public static String x509CertificateToPem(final X509Certificate cert) throws IOException {
    final StringWriter writer = new StringWriter();
    final JcaPEMWriter pemWriter = new JcaPEMWriter(writer);
    pemWriter.writeObject(cert);
    pemWriter.flush();
    pemWriter.close();
    return writer.toString();
}