@Override
public String getTlsInfo() {
    StringBuilder stringBuilder = new StringBuilder(  );
    X509Certificate[] certs = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
    for (X509Certificate cert: certs) {
        stringBuilder.append(cert.getSubjectX500Principal().getName());
    }
    return stringBuilder;
}