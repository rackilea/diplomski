//Get Private Key
RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
KeyFactory fact = KeyFactory.getInstance("RSA");
RSAPrivateKey privateKey = (RSAPrivateKey) fact.generatePrivate(rsaPrivateKeySpec);

return (RSAPrivateKey) privateKey;