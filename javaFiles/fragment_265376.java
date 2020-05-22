SecureRandom ranGen = new SecureRandom();
    byte[] aesKey = new byte[16]; // 16 bytes = 128 bits
    ranGen.nextBytes(aesKey);
    String a = new BASE64Encoder().encode(aesKey);

    System.out.println(a);

    byte[] b = new BASE64Decoder().decodeBuffer(a);
    System.out.println(new BASE64Encoder().encode(b));

    for (int i = 0; i < aesKey.length; i++) {
        System.out.println(aesKey[i] + " " + b[i]);
    }