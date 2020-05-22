// Read file to a byte array.
String privateKeyFileName = "C:\\myPrivateKey.der";   
Path path = Paths.get(privateKeyFileName);
byte[] privKeyByteArray = Files.readAllBytes(path);

PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privKeyByteArray);

KeyFactory keyFactory = KeyFactory.getInstance("RSA");

PrivateKey myPrivKey = keyFactory.generatePrivate(keySpec);

System.out.println("Algorithm: " + myPrivKey.getAlgorithm());