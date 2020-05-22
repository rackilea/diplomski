String modulus = "modulus from Apple";
  String exponent = "exponent from Apple";
  byte[] modulusByte = Base64.getUrlDecoder().decode(modulus);

  BigInteger modulusAsBigInt = new BigInteger(1, modulusByte);
  byte[] exponentByte = Base64.getUrlDecoder().decode(exponent);
  BigInteger exponentAsBigInt = new BigInteger(1, exponentByte);

  RSAPublicKeySpec spec = new RSAPublicKeySpec(modulusAsBigInt, exponentAsBigInt);
  KeyFactory factory = KeyFactory.getInstance("RSA");
  PublicKey pub = factory.generatePublic(spec);