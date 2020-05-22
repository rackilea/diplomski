KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
Key pubKey = keyPair.getPublic();  // add this
PrivateKey privateKey = keyPair.getPrivate();
// several lines later...
// Initiate the cipher
cipher.init(Cipher.ENCRYPT_MODE, pubKey);  // change privateKey to pubKey