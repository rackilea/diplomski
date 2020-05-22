SSLSocketFactory sslSocketFactory = sslContext().getSocketFactory();

//Note that MQEnvironment is used with IBM MQ Classes for Java not IBM MQ Classes for JMS
MQEnvironment.sslSocketFactory = sslSocketFactory;
MQEnvironment.sslCipherSuite = "TLS_RSA_WITH_AES_256_CBC_SHA";
MQEnvironment.sslFipsRequired = false;

mqQueueConnectionFactory.setSSLSocketFactory(sslSocketFactory);

private SSLContext sslContext() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

    try (InputStream cert = new FileInputStream("C:\\myplace\\Dev\\Certificates\\MY_KEYSTORE.jks")) {

        final KeyStore caCertsKeyStore = KeyStore.getInstance("JKS");
        caCertsKeyStore.load(cert, "changeit".toCharArray());

        final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        final TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        CertPathBuilder cpb = CertPathBuilder.getInstance("PKIX");
        PKIXRevocationChecker rc = (PKIXRevocationChecker)cpb.getRevocationChecker();
        rc.setOptions(EnumSet.of(
                PKIXRevocationChecker.Option.PREFER_CRLS,
                PKIXRevocationChecker.Option.ONLY_END_ENTITY,
                PKIXRevocationChecker.Option.SOFT_FAIL,
                PKIXRevocationChecker.Option.NO_FALLBACK));

        PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(caCertsKeyStore, new X509CertSelector());
        pkixParams.addCertPathChecker(rc);

        kmf.init(caCertsKeyStore, "changeit".toCharArray());
        tmf.init( new CertPathTrustManagerParameters(pkixParams) );

        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());

        return sslContext;

    } catch (Exception e) {
        throw new RuntimeException("Exception creating SSLContext", e);
    }
}