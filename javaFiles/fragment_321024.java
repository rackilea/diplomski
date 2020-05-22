//.... omitted
    ByteBuffer byteBuffer = getByteBuffer(plaintext);
    EncryptRequest encryptRequest = new EncryptRequest().withKeyId(keyId"").withPlaintext(byteBuffer);
    EncryptResult encryptResult = client.encrypt(encryptRequest);
    String ciphertext = getString(java.util.Base64.getEncoder().encode(encryptResult.getCiphertextBlob()));
//.... omitted