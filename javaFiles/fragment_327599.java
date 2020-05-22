// get privkey and chain from keystore to local variables as above
// below Java 8 must declare them final (after that it's implicit) 
one = null; // so _not_ effectively captured

KeyManager km = new X509ExtendedKeyManager (){
  // anonymous (local) class captures privkey and chain variables from containing method
  public X509Certificate[] getCertificateChain(String alias){ return (X509Certificate[]) chain; }
  // KeyStore API is declared using abstract java.security.cert.Certificate but implementations 
  // actually use specific java.security.cert.X509Certificate or a subclass so cast works
  public PrivateKey getPrivateKey(String alias){ return privkey; }
  public String[] getClientAliases(String keyType, Principal[] issuers){ return new String[]{"dummy"}; }
  public String[] getServerAliases(String keyType, Principal[] issuers){ return new String[]{"dummy"}; }
  // at least one of these depending how this (context and) keymanager will be used:
  public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket){ return "dummy"; }
  public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket){ return "dummy"; }
  public String chooseEngineClientAlias(String[] keyType, Principal[] issuers, SSLEngine engine){ return "dummy"; }
  public String chooseEngineServerAlias(String keyType, Principal[] issuers, SSLEngine engine){ return "dummy"; }
};