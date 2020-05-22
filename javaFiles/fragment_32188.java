public static String convertCertToPem(final PKCS10CertificationRequest certRequest) throws IOException {
    final StringWriter writer = new StringWriter();
    final JcaPEMWriter pemWriter = new JcaPEMWriter(writer);
    pemWriter.writeObject(certRequest);
    pemWriter.flush();
    pemWriter.close();
    return writer.toString();
}