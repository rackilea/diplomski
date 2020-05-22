// iv is 8 bytes of the input
        byte[] inputBytes = Base64.getDecoder().decode(INPUT);
        byte[] salt = new byte[SALT_LENGTH];
        System.arraycopy(inputBytes, 0, salt, 0, SALT_LENGTH);
        byte[] encrypted = new byte[inputBytes.length - SALT_LENGTH];
        System.arraycopy(inputBytes, SALT_LENGTH, encrypted, 0, encrypted.length);