public static void fileDecryptWrapped(File in, File out, PrivateKey priv)
        throws GeneralSecurityException, IOException {

    Signature signature = Signature.getInstance("SHA1WITHRSA");
    signature.initSign(priv);
    signature.update("test".getBytes());
    byte[] bufferKey = signature.sign();

    // First we must to take the wrapped key in the first bufferKey.length bytes of the file
    InputStream is = new FileInputStream(in);
    if (is.read(bufferKey) != bufferKey.length) { 
        is.close();
        throw new IllegalStateException("Too short file");
    }

    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.UNWRAP_MODE, priv);
    Key aesKey = cipher.unwrap(bufferKey, "AES", Cipher.SECRET_KEY);

    // Now we must to decrypt the rest of the file
    cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
    cipher.init(Cipher.DECRYPT_MODE, aesKey);

    CipherInputStream ix = new CipherInputStream(is, cipher);
    FileOutputStream os = new FileOutputStream(out);

    copy(ix, os);

    ix.close();
    os.close();
}