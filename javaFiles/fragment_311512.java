// once the server and ssl context factory are both started
SSLEngine engine = sslContextFactory.newSSLEngine();
String enabledProtocols[] = engine.getEnabledProtocols();
String supportedProtocols[] = engine.getSupportedProtocols();
String enabledCiphers[] = engine.getEnabledCipherSuites();
String supportedCiphers[] = engine.getSupportedCipherSuites();