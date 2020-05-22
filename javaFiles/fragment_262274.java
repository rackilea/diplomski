File file = new File(path);
        fis = new FileInputStream(file);

        toDecrypt = new byte[(int)file.length()];
        fis.read(toDecrypt);

        byte[] decrypted = CipherUtils.DecryptByteArray(toDecrypt);
        FileOutputStream decryptedStream = new FileOutputStream(bookPath);
        decryptedStream.write (decrypted);
        decryptedStream.close();