// this is to convert HEX to bytes
public static byte[] convertHexToBytes(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
}

// this is the same as initial version, but we don't handle PKCS5 padding here
public static byte[] decrypt(byte[] keyData, byte[] ciphertext)
        throws CryptoException, IOException {

    // First, create the AESKey again.
    AESKey key = new AESKey(keyData);

    // Now, create the decryptor engine.
    AESDecryptorEngine engine = new AESDecryptorEngine(key);

    // Create the BlockDecryptor to hide the decryption details away.
    ByteArrayInputStream input = new ByteArrayInputStream(ciphertext);
    BlockDecryptor decryptor = new BlockDecryptor(engine, input);

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

// and finally :)
String key =       "1234567890123456";
String encrypted = "48b983c4f1575280d244b74cf689efe5";

byte[] keyBytes = key.getBytes();
byte[] encryptedBytes = convertHexToBytes(encrypted);

// displays "nirav bhandari"
Dialog.inform(new String(decrypt(keyBytes, encryptedBytes)));