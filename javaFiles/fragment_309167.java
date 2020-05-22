public static void main(String[] args) throws Exception{

    SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    SSLSocket socket = (SSLSocket)factory.createSocket("www.google.com", 443);

    X509Certificate[] chain = socket.getSession().getPeerCertificateChain();

    String equifax = chain[2].getIssuerDN().getName();

    // JVM Default Trust Managers
    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init((KeyStore) null);
    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

    X509TrustManager manager = (X509TrustManager) trustManagers[0];

    for (java.security.cert.X509Certificate x509Certificate : manager.getAcceptedIssuers()) {
        if (equifax.equals(x509Certificate.getSubjectDN().getName())) {
            System.out.println(x509Certificate);
        }
    }

}