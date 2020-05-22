X509SSLContextFactory sslContextFactory = new X509SSLContextFactory();
// By default, this would use the keystore passed with the usual system properties.

sslContextFactory.setKeyManagerWrapper(
    new FixedServerAliasKeyManager.Wrapper("the-alias-you-want"));
// You could read the alias name from a custom system property, for example.

SSLContext sslContext = sslContextFactory.buildSSLContext("TLS");
SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();