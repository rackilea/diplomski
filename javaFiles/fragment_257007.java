//Convert hex strings to BigInteger
BigInteger privateExponent = new BigInteger(privateExponentHex, 16);
BigInteger modulus = new BigInteger(modulusHex, 16);

//Build the private key
KeyFactory keyFactory = KeyFactory.getInstance("RSA");
RSAPrivateKeySpec privateSpec = new RSAPrivateKeySpec(modulus, privateExponent);
PrivateKey privateKey = keyFactory.generatePrivate(privateSpec);