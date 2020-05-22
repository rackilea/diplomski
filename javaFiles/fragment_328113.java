package blabla.fileencrypter;

import lots;

/**
 * The FileEncoder class provides an interface to allow for easy encrypting and decrypting of files. To use this class, first call both {@link #setSalts(String, String)} and {@link #setFolders(String, String)}.
 * @author Daniël van den Berg
 * @since Nov 26, 2015
 *
 */
public class FileEncrypter {
    private static String encryptedFolder = "";
    private static String decryptedFolder = "";
    private static byte[] salt = null;
    private static String encryptedPostfix = "";
    private static final HashMap<Integer, HashMap<String,Cipher>> ciphers = new HashMap<Integer, HashMap<String, Cipher>>();

    /**
     * Sets the folders the documents have to be placed in.
     * @param encryptedFolder The folder encrypted files have to be placed in.
     * @param decryptedFolder The folder decrypted files have to be placed in.
     */
    public static void setFolders(String encryptedFolder, String decryptedFolder){
        FileEncrypter.encryptedFolder = encryptedFolder;
        FileEncrypter.decryptedFolder = decryptedFolder;
    }

    /**
     * A postfix to give to encrypted files. Can be "" for no postfix.
     * @param extension The postfix to append to encrypted files.
     */
    public static void setEncryptedPostfix(String extension){
        if (extension != null){
            FileEncrypter.encryptedPostfix = extension;
        }else{
            FileEncrypter.encryptedPostfix = "";
        }
    }

    /**
     * The salts to use when encrypting/decrypting files.
     * @param salt The salt to use.
     * @param ivParameterSpec The buffer with the IV.
     * @throws FileEncryptingException When the ivParameterSpec is smaller than 16 bytes.
     */
    public static void setSalts(String salt) throws FileEncryptingException{
        FileEncrypter.salt = salt.getBytes();
    }

    /**
     * Encode the given inputFile with the given key.
     * @param inputFile The file to encrypt.
     * @param key The key to use for encrypting the file.
     * @return The encrypted file.
     * @throws FileEncryptingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IOException
     * @throws InvalidKeySpecException
     * @throws InvalidAlgorithmParameterException
     */
    public static File encrypt(File inputFile, String key) throws FileEncryptingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException, InvalidAlgorithmParameterException{
        if (isEncrypted(inputFile)){
            throw new FileEncryptingException("File not decrypted: "+inputFile.getAbsolutePath());
        }

        FileInputStream inputStream = new FileInputStream(inputFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        File outputFile = new File(inputFile.getAbsolutePath().replace(decryptedFolder,encryptedFolder) + encryptedPostfix);
        outputFile.getParentFile().mkdirs();
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        processStream(Cipher.ENCRYPT_MODE,key,bufferedInputStream,bufferedOutputStream);
        inputStream.close();
        outputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        return outputFile;
    }

    /**
     * Decrypt the given inputFile with the given key.
     * @param inputFile The file to decrypt.
     * @param key The key to use for decrypting the file.
     * @return The decrypted file.
     * @throws FileEncryptingException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws InvalidAlgorithmParameterException
     */
    public static File decrypt(File inputFile, String key) throws FileEncryptingException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException, InvalidAlgorithmParameterException{
        if (!isEncrypted(inputFile)){
            throw new FileEncryptingException("File not encrypted: "+inputFile.getAbsolutePath());
        }

        if (!inputFile.exists() && !inputFile.getAbsolutePath().contains(encryptedPostfix)){
            inputFile = new File(inputFile.getAbsolutePath()+encryptedPostfix);
        }

        FileInputStream inputStream = new FileInputStream(inputFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        File outputFile = new File(inputFile.getAbsolutePath().replace(encryptedPostfix, "").replace(encryptedFolder,decryptedFolder));
        outputFile.getParentFile().mkdirs();
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        processStream(Cipher.DECRYPT_MODE,key,bufferedInputStream,bufferedOutputStream);
        inputStream.close();
        outputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        return outputFile;
    }

    /**
     * Used for generating a cipher.
     * @param cipherMode The cipher mode to use. Either <code>Cipher.DECRYPT_MODE</code> or <code>Cipher.ENCRYPT_MODE</code>
     * @param key The key to generate the cipher with.
     * @return The generated cipher.
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     */
    private static Cipher getCipher(int cipherMode, String key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (!ciphers.containsKey(cipherMode)){
            synchronized (ciphers){
                if (!ciphers.containsKey(cipherMode)){
                    ciphers.put(cipherMode, new HashMap<String,Cipher>());
                }
            }
        }
        HashMap<String, Cipher> hashMap = ciphers.get(cipherMode);
        if (!hashMap.containsKey(key)){
            synchronized (hashMap) {
                if (!hashMap.containsKey(key)){
                    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                    KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 128);
                    SecretKey tmp = factory.generateSecret(spec);
                    SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "RC4");

                    Cipher c = Cipher.getInstance("RC4");
                    c.init(cipherMode, secret);
                    hashMap.put(key, c);
                }
            }
        }
        return hashMap.get(key);
    }

    /**
     * Process a stream. This will encrypt or decrypt the stream, depending on the given cipherMode. The output will be available in the given {@link OutputStream}.
     * @param cipherMode The cipher mode to use. Either <code>Cipher.DECRYPT_MODE</code> or <code>Cipher.ENCRYPT_MODE</code>
     * @param key The key to use for decryption/encryption.
     * @param inputStream The stream to read from.
     * @param outputStream The stream to write the encrypted/decrypted result to.
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws IOException
     */
    public static void processStream(int cipherMode, String key, InputStream inputStream, OutputStream outputStream) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IOException{
        Cipher c = getCipher(cipherMode,key);
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, c);
        int b = 0;
        while ((b = inputStream.read()) !=-1){
            cipherOutputStream.write(b);
        }
        cipherOutputStream.close();
    }

    /**
     * Returns a file, no matter whether it's encrypted or not. See {@link #isEncrypted(File)} to detect if the file is encrypted.
     * @param filenameDecrypted The filename the decrypted file would have.
     * @return The file that corresponds with the given filename.
     */
    public static File getFile(String filenameDecrypted){
        if (!filenameDecrypted.contains(decryptedFolder) && !filenameDecrypted.contains(encryptedFolder)){
            filenameDecrypted = decryptedFolder + filenameDecrypted;
        }
        File file = new File(filenameDecrypted);
        if (!file.exists()){
            file = new File(filenameDecrypted.replace(decryptedFolder, encryptedFolder)+encryptedPostfix);
        }
        return file;
    }

    /**
     * Checks if the file is encrypted or not.
     * @param file The file to check.
     * @return True if the file is encrypted, false otherwise.
     */
    public static boolean isEncrypted(File file){
        return file.getAbsolutePath().contains(encryptedFolder) || (!encryptedPostfix.isEmpty() && file.getAbsolutePath().contains(encryptedPostfix));
    }
}