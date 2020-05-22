//path to private key file
String PRIVATE_KEY_FILE_RSA = "C:\\Users\\Adey";
FileInputStream in = new FileInputStream(PRIVATE_KEY_FILE_RSA);
// passphrase - the key to decode private key
String passphrase = "somepass";
PKCS8Key pkcs8 = new PKCS8Key(in, passphrase.toCharArray());
byte[] decrypted = pkcs8.getDecryptedBytes();
PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decrypted);
RSAPrivateKey privKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(spec);