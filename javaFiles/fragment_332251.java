cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    byte[] cipherBytes = cipher.doFinal(input);
    System.out.println("cipher: " + new String(cipherBytes));
    String returnValue = new String(cipherBytes);

    String cipherText = Base64.getEncoder().encodeToString(cipherBytes);
    byte[] reCipherBytes = Base64.getDecoder().decode(cipherText);

    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    byte[] plainText = cipher.doFinal(reCipherBytes);
    System.out.println("plain : " + new String(plainText));