// read digest of the file
    int digestLength = fromClient.readInt();
    byte[] digest = new byte[digestLength];
    fromClient.readFully(digest);

    // decrypt it
    AesCipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedDigest = AesCipher.doFinal(digest);

    // read file name to be received
    String fileName = fromClient.readUTF();

    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
    FileOutputStream fos = new FileOutputStream(file);
    BufferedOutputStream bos = new BufferedOutputStream(fos);

    // read file bytes from client
    int fileLength = fromClient.readInt();
    byte[] fileBytes = new byte[fileLength];
    fromClient.readFully(fileBytes);

    AesCipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedByte = AesCipher.doFinal(fileBytes);
    bos.write(decryptedByte, 0, decryptedByte.length);
    bos.close();