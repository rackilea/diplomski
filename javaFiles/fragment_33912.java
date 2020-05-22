String key = "3082012230..."; // full key omitted for brevity
byte[] derPublicKey = DatatypeConverter.parseHexBinary(key);

KeyFactory keyFactory = KeyFactory.getInstance("RSA");
X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(derPublicKey);
keyFactory.generatePublic(publicKeySpec);