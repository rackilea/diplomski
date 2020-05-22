KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
KeyPair pair = gen.generateKeyPair();
FileOutputStream ospvt = new FileOutputStream("pvt.der");
try {
  ospvt.write(pair.getPrivate().getEncoded());
  ospvt.flush();
} finally {
  ospvt.close();
}
FileOutputStream ospub = new FileOutputStream("pub.der");
try {
  ospub.write(pair.getPublic().getEncoded());
  ospub.flush();
} finally {
  ospub.close();
}