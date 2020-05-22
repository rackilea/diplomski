class MultiKeyStoreManager implements X509KeyManager {
 private static final Logger logger = Logger.getLogger(MultiKeyStoreManager.class); 
 private final X509KeyManager jvmKeyManager;
 private final X509KeyManager customKeyManager;

 public MultiKeyStoreManager(X509KeyManager jvmKeyManager, X509KeyManager customKeyManager ) {
  this.jvmKeyManager = jvmKeyManager;
  this.customKeyManager = customKeyManager;  
 }

 @Override
 public String chooseClientAlias(String[] keyType, Principal[] issuers, Socket socket) {
  // try the first key manager
  String alias = customKeyManager.chooseClientAlias(keyType, issuers, socket);
  if( alias == null ) {
   alias = jvmKeyManager.chooseClientAlias(keyType, issuers, socket);
   logger.warn("Reverting to JVM CLIENT alias : " + alias);
  }

  return alias;

 }

 @Override
 public String chooseServerAlias(String keyType, Principal[] issuers, Socket socket) {
  // try the first key manager
  String alias = customKeyManager.chooseServerAlias(keyType, issuers, socket);
  if( alias == null ) {
   alias =  jvmKeyManager.chooseServerAlias(keyType, issuers, socket);
   logger.warn("Reverting to JVM Server alias : " + alias);
  } 
  return alias;
 }

 @Override
 public X509Certificate[] getCertificateChain(String alias) {
  X509Certificate[] chain = customKeyManager.getCertificateChain(alias);
  if( chain == null || chain.length == 0) {
   logger.warn("Reverting to JVM Chain : " + alias);
   return jvmKeyManager.getCertificateChain(alias);
  } else {
   return chain;
  }  
 }

 @Override
 public String[] getClientAliases(String keyType, Principal[] issuers) {
  String[] cAliases = customKeyManager.getClientAliases(keyType, issuers);
  String[] jAliases = jvmKeyManager.getClientAliases(keyType, issuers);
  logger.warn("Supported Client Aliases Custom: " + cAliases.length + " JVM : " + jAliases.length);
  return ArrayUtils.join(cAliases,jAliases);
 }

 @Override
 public PrivateKey getPrivateKey(String alias) {
  PrivateKey key = customKeyManager.getPrivateKey(alias);
  if( key == null ) {
   logger.warn("Reverting to JVM Key : " + alias);
   return jvmKeyManager.getPrivateKey(alias);
  } else {
   return key;
  }
 }

 @Override
 public String[] getServerAliases(String keyType, Principal[] issuers) {
  String[] cAliases = customKeyManager.getServerAliases(keyType, issuers);
  String[] jAliases = jvmKeyManager.getServerAliases(keyType, issuers);
  logger.warn("Supported Server Aliases Custom: " + cAliases.length + " JVM : " + jAliases.length);
  return ArrayUtils.join(cAliases,jAliases);
 }

}