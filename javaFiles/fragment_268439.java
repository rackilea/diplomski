public class RijndaelEncryption {

    public String encryptString(String word, String password, byte[] salt, int iterations, int keySize, int blockSize) {
        try {
            byte[] pswd = sha256String(password, "UTF-8");
            PKCS5S2ParametersGenerator key = keyGeneration(pswd, salt, iterations);
            ParametersWithIV iv = generateIV(key, keySize, blockSize);
            BufferedBlockCipher cipher = getCipher(true, iv);
            byte[] inputText = word.getBytes("UTF-8");
            byte[] newData = new byte[cipher.getOutputSize(inputText.length)];
            int l = cipher.processBytes(inputText, 0, inputText.length, newData, 0);
            cipher.doFinal(newData, l);
            return new String(Base64.encode(newData), "UTF-8");
        } catch (UnsupportedEncodingException | IllegalStateException | DataLengthException | InvalidCipherTextException e) {
            return null;
        }
    }

    public BufferedBlockCipher getCipher(boolean encrypt, ParametersWithIV iv) {
        RijndaelEngine rijndael = new RijndaelEngine();
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(rijndael));
        cipher.init(encrypt, iv);
        return cipher;
    }

    public ParametersWithIV generateIV(PKCS5S2ParametersGenerator key, int keySize, int blockSize) {
        try {
            ParametersWithIV iv = null;
            iv = ((ParametersWithIV) key.generateDerivedParameters(keySize, blockSize));
            return iv;
        } catch (Exception e) {
            return null;
        }
    }

    public PKCS5S2ParametersGenerator keyGeneration(byte[] password, byte[] salt, int iterations) {
        try {
            PKCS5S2ParametersGenerator key = new PKCS5S2ParametersGenerator();
            key.init(password, salt, iterations);
            return key;
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] sha256String(String password, Charset charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes(charset));
            return md.digest();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }

    public byte[] sha256String(String password, String charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes(charset));
            return md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return null;
        }
    }
}