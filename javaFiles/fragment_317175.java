KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
keyPairGenerator.initialize(1024);
KeyPair keyPair = keyPairGenerator.genKeyPair();

// extract the encoded private key, this is an unencrypted PKCS#8 private key
byte[] encodedprivkey = keyPair.getPrivate().getEncoded();
System.out.println(Base64.encodeBase64String(encodedprivkey));