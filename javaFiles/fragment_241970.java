private byte[] encryptKeyBytes(String keyName, byte[] keyBytes, byte[] pgpKey)
    throws GeneralSecurityException {
  ByteArrayOutputStream encKeyBytes = new ByteArrayOutputStream(keyBytes.length);

  try (Handle<SecureRandom> randomHandle = RngSupport.getRandom()) {
    JcePGPDataEncryptorBuilder encryptorBuilder =
        new JcePGPDataEncryptorBuilder(PGPEncryptedDataGenerator.AES_256);
    encryptorBuilder.setWithIntegrityPacket(true);
    encryptorBuilder.setSecureRandom(randomHandle.getObject());
    encryptorBuilder.setProvider("BC");

    PGPEncryptedDataGenerator encryptor = new PGPEncryptedDataGenerator(encryptorBuilder);
    try {
      JcePublicKeyKeyEncryptionMethodGenerator keyEncryptionMethodGenerator =
          new JcePublicKeyKeyEncryptionMethodGenerator(resolvePgpPublicKey(pgpKey));
      keyEncryptionMethodGenerator.setProvider("BC");
      encryptor.addMethod(keyEncryptionMethodGenerator);

      PGPLiteralDataGenerator dataGenerator = new PGPLiteralDataGenerator();
      byte[] data = BytesSupport.encodeHex(keyBytes).getBytes(StandardCharsets.UTF_8);
      try (
          OutputStream ao = new ArmoredOutputStream(encKeyBytes);
          OutputStream eo = encryptor.open(ao, keyBytes.length);
          OutputStream go = dataGenerator.open(
              eo, PGPLiteralData.UTF8, keyName, data.length, new Date())) {
        go.write(data);
      }
    } catch (ServiceRequestException e) {
      throw e;
    } catch (Exception e) {
      throw new GeneralSecurityException("Cannot perform PGP encryption on the content key", e);
    }
  }

  return encKeyBytes.toByteArray();
}