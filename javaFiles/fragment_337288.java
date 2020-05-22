//Get Private Key
RSAPrivateCrtKeySpec rsaPrivateCrtKeySpec = new RSAPrivateCrtKeySpec(modulus, exponent, exponent, exponent, exponent, exponent, exponent, exponent);
KeyFactory fact = KeyFactory.getInstance("RSA");
RSAPrivateKey privateKey = (RSAPrivateKey) fact.generatePrivate(rsaPrivateCrtKeySpec);

return (RSAPrivateCrtKey) privateKey;