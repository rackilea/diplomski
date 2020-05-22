private static String encrypt(InputStream inputStream, SecretKeys secretKeys, File fileToWrite)
            throws GeneralSecurityException {
  Cipher aesCipherForEncryption = Cipher.getInstance(CIPHER_TRANSFORMATION);
  aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKeys.getConfidentialityKey(), new IvParameterSpec(secretKeys.getIv()));

  saveFile(inputStream, aesCipherForEncryption, fileToWrite);
  return secretKeys.toString();
}