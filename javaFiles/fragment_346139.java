public void processSoapSecurityHeader(String soapRequest, String keyStore, String keyStorePwd, String alias) throws Exception {

    SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(null, new  ByteArrayInputStream(soapRequest.getBytes()));
    FileInputStream is = new FileInputStream(keyStore);
    KeyPair keypair = null;
    KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
    keystore.load(is, keyStorePwd.toCharArray());
    Certificate cert = null;
    Key key = keystore.getKey(alias, keyStorePwd.toCharArray());
    if (key instanceof PrivateKey) {
      cert = keystore.getCertificate(alias);
      PublicKey publicKey = cert.getPublicKey();
      keypair = new KeyPair(publicKey, (PrivateKey) key);
    }
     Properties properties = new Properties();
     properties.setProperty("org.apache.ws.security.crypto.provider", "org.apache.ws.security.components.crypto.Merlin");
     Crypto crypto = CryptoFactory.getInstance(properties);
     keystore.setKeyEntry(alias, keypair.getPrivate(), keyStorePwd.toCharArray(), new Certificate[]{cert});
     ((Merlin) crypto).setKeyStore(keystore);
     crypto.loadCertificate(new ByteArrayInputStream(cert.getEncoded()));
     WSSecurityEngine engine = new WSSecurityEngine();
     WSSConfig config = WSSConfig.getNewInstance();
     config.setWsiBSPCompliant(false);
     engine.setWssConfig(config);
     List<WSSecurityEngineResult> res = engine.processSecurityHeader(toDocument(soapMessage), null, null, crypto);
     for (WSSecurityEngineResult ers : res) {
           LOG.trace("Details of security header after validation {}" , ers.toString());
     }
     LOG.debug("Validation code executed");
}