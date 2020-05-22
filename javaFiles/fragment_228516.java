public static byte[] decrypt(byte[] keyData, byte[] ciphertext) 
         throws CryptoException, IOException {

    // First, create the AESKey again.
    AESKey key = new AESKey(keyData);

    // Now, create the decryptor engine.
    AESDecryptorEngine engine = new AESDecryptorEngine(key);
    // Since we cannot guarantee that the data will be of an equal block length
    // we want to use a padding engine (PKCS5 in this case).
    PKCS5UnformatterEngine uengine = new PKCS5UnformatterEngine(engine);

    // Create the BlockDecryptor to hide the decryption details away.
    ByteArrayInputStream input = new ByteArrayInputStream(ciphertext);
    BlockDecryptor decryptor = new BlockDecryptor(uengine, input);

    // Now, read in the data.
    byte[] temp = new byte[100];
    DataBuffer buffer = new DataBuffer();

    for (;;) {
        int bytesRead = decryptor.read(temp);
        buffer.write(temp, 0, bytesRead);

        if (bytesRead < 100) {
            // We ran out of data.
            break;
        }
    }

    byte[] plaintext = buffer.getArray();

    return plaintext;
}