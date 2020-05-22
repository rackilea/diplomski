private void encrypt(File inputFile, File outputFile)  {
    //Declare / Initialize the Data, Convert the Input to Bytes and encrypt or decrypt using doFinal.
    FileInputStream inputStream = new FileInputStream(inputFile);
    byte[] inputBytes = new byte[(int) inputFile.length()];
    byte[] iv = new byte[16]; // 16 for AES-CBC
    SecureRandom prng = new SecureRandom(); //Use SecureRandom to generate random bits. The size of the IV matches the blocksize of the cipher
    prng.nextBytes(iv); //Construct the appropriate IvParameterSpec object for the data to pass to Cipher's init() method

    //Create a Cipher by specifying the following parameters: Alg name, Mode (CBC), Padding (PKC7/PKCS5)
    Cipher cipherForEncryption = Cipher.getInstance(UITest.getSendAlg() + "/CBC/PKCS5PADDING"); // Must specify the mode explicitly as most JCE providers default to ECB mode

    //Initialize the Cipher for Encryption
    cipherForEncryption.init(cipherMode, secretKey, new IvParameterSpec(iv));      
        inputStream.read(inputBytes);
        byte[] outputBytes = cipherForEncryption.doFinal(inputBytes);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(iv);
        outputStream.write(outputBytes);
        outputStream.flush();
        inputStream.close();
        outputStream.close();
    }
}

private void decrypt(File inputFile, File outputFile) {
    //Declare / Initialize the Data, Convert the Input to Bytes and encrypt or decrypt using doFinal.
    FileInputStream inputStream = new FileInputStream(inputFile);
    byte[] inputBytes = new byte[(int) inputFile.length()-16];
    byte[] iv = new byte[16]; // 16 for AES-CBC

    //Create a Cipher by specifying the following parameters: Alg name, Mode (CBC), Padding (PKC7/PKCS5)
    Cipher cipherForEncryption = Cipher.getInstance(UITest.getSendAlg() + "/CBC/PKCS5PADDING"); // Must specify the mode explicitly as most JCE providers default to ECB mode

    //Initialize the Cipher for Encryption
    cipherForEncryption.init(cipherMode, secretKey, new IvParameterSpec(iv));      
    inputStream.read(iv);
    inputStream.read(inputBytes);
    byte[] outputBytes = cipherForEncryption.doFinal(inputBytes);
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    outputStream.write(outputBytes);
    outputStream.flush();
    inputStream.close();
    outputStream.close();
}