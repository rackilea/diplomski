KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
KeyPair keyPair = generator.generateKeyPair();

final PrivateKey privKey = keyPair.getPrivate();

JceOpenSSLPKCS8EncryptorBuilder builder =
    new JceOpenSSLPKCS8EncryptorBuilder(PKCS8Generator.PBE_SHA1_3DES);

builder.setIterationCount(10000);
builder.setPasssword("Hello, World!".toCharArray());

OutputEncryptor outputEncryptor = builder.build();    
PKCS8Generator pkcs8Generator =
    new JcaPKCS8Generator(privKey, outputEncryptor);

try (PemWriter writer = new PemWriter(new PrintWriter(System.out))) {
  writer.writeObject(pkcs8Generator);
}