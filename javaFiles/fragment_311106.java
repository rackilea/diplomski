KeyFactory fact = KeyFactory.getInstance("RSA");
RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
  RSAPublicKeySpec.class);
RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
  RSAPrivateKeySpec.class);

saveToFile("public.key", pub.getModulus(),
  pub.getPublicExponent());
saveToFile("private.key", priv.getModulus(),
  priv.getPrivateExponent());