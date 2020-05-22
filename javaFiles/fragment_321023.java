//.... omitted
    ByteBuffer buffer = getByteBuffer(ciphertext);
    DecryptRequest decryptRequest = new DecryptRequest().withCiphertextBlob(buffer);
    DecryptResult decryptResult = client.decrypt(decryptRequest);
    String plaintext = getString(decryptResult.getPlaintext());
//.... omitted