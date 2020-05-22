public static String decrypt(String valueToDecrypt) throws Exception {
    AESCrypt enc = new AESCrypt();
    return new String(enc.decryptInternal(valueToDecrypt)).trim();
}

private byte[] decryptInternal(String code) throws Exception {
    if (code == null || code.length() == 0) {
        throw new Exception("Empty string");
    }

    byte[] decrypted = null;
    try {


        byte[] key= SecretKey.getBytes("UTF-8");
        PaddedBufferedBlockCipher c = new PaddedBufferedBlockCipher(new RijndaelEngine(256), new ZeroBytePadding());
        CipherParameters params= new KeyParameter(key);`
        // false because its going to decrypt
        c.init(false,params);
        decrypted= GetData(c,(Base64.decode(code,Base64.DEFAULT));

    } catch (Exception e) {
        throw new Exception("[decrypt] " + e.getMessage());
    }
    return decrypted;
}


private static byte[] GetData(PaddedBufferedBlockCipher cipher, byte[] data) throws InvalidCipherTextException
{
    int minSize = cipher.getOutputSize(data.length);
    byte[] outBuf = new byte[minSize];
    int length1 = cipher.processBytes(data, 0, data.length, outBuf, 0);
    int length2 = cipher.doFinal(outBuf, length1);
    int actualLength = length1 + length2;
    byte[] cipherArray = new byte[actualLength];
    for (int x = 0; x < actualLength; x++) {
        cipherArray[x] = outBuf[x];
    }
    return cipherArray;
}