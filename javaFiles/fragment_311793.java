Key key = keystore.getKey(alias, "password".toCharArray());
if (key instanceof PrivateKey) {
  // Get certificate of public key
  Certificate cert = keystore.getCertificate(alias);

  //Answer > get the DN from 'cert.getSubjectDN()`

  // Get public key
  PublicKey publicKey = cert.getPublicKey();
  //publicKey is NOT where you can get the certificate DN....