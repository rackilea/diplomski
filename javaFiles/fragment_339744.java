byte[] publicExponentBytes = Base64.getUrlDecoder().decode(jwkPublic.e);
byte[] privateExponentBytes = Base64.getUrlDecoder().decode(jwkPrivate.d);
byte[] modulusBytes = Base64.getUrlDecoder().decode(jwkPublic.n);

BigInteger publicExponent = new BigInteger(1, publicExponentBytes );
BigInteger privateExponent = new BigInteger(1, privateExponentBytes);
BigInteger modulus = new BigInteger(1, modulusBytes);