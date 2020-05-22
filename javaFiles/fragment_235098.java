RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);
KeyFactory factory = KeyFactory.getInstance("RSA");
PublicKey pub = factory.generatePublic(spec);
Signature verifier = Signature.getInstance("SHA1withRSA");
verifier.initVerify(pub);
verifier.update(url.getBytes("UTF-8")); // Or whatever interface specifies.
boolean okay = verifier.verify(signature);