final SslContext sslCtx;
        TrustManagerFactory trustManagerFactory = InsecureTrustManagerFactory.INSTANCE;
        SslProvider provider = SslContext.defaultClientProvider();
        File trustCertChainFile = null;
        File keyCertChainFile = null;
        File keyFile = null;
        String keyPassword = null;
        KeyManagerFactory keyManagerFactory = null;
        Iterable<String> ciphers = null;
        ApplicationProtocolConfig apn = null;
        switch (provider) {
            case JDK:
                sslCtx = new JdkSslClientContext(
                        trustCertChainFile, trustManagerFactory, keyCertChainFile, keyFile, keyPassword,
                        keyManagerFactory, ciphers, IdentityCipherSuiteFilter.INSTANCE, apn, 0, 0);
                break;
            case OPENSSL:
            default:
                sslCtx = new OpenSslClientContext(
                        trustCertChainFile, trustManagerFactory,
                        ciphers, apn, 0, 0);
                break;
        }