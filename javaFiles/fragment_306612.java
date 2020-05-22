FileEncryption secure = new FileEncryption();

    // Encrypt code
    {
        File encryptFile = new File("encrypt.data");
        File publicKeyData = new File("public.der");
        File originalFile = new File("sys_data.db");
        File secureFile = new File("secure.data");

        // create AES key
        secure.makeKey();

        // save AES key using public key
        secure.saveKey(encryptFile, publicKeyData);

        // save original file securely 
        secure.encrypt(originalFile, secureFile);
    }

    // Decrypt code
    {
        File encryptFile = new File("encrypt.data");
        File privateKeyFile = new File("private.der");
        File secureFile = new File("secure.data");
        File unencryptedFile = new File("unencryptedFile");

        // load AES key
        secure.loadKey(encryptFile, privateKeyFile);

        // decrypt file
        secure.decrypt(secureFile, unencryptedFile);
    }