byte[] decodedModulus = Base64.getUrlDecoder().decode(yourModulus);

byte[] decodedExponent = Base64.getUrlDecoder().decode(yourExponent);

BigInteger modulus = new BigInteger(1, decodedModulus);
BigInteger exponent = new BigInteger(1, decodedExponent);

RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(modulus, exponent);
KeyFactory keyFactory;

keyFactory = KeyFactory.getInstance("RSA");
PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);
Boolean verify = parsedToken.verify(verifier);}