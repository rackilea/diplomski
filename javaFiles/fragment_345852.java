byte[] salt = new byte[8];
    Arrays.fill(salt, (byte)1);
    PBEParametersGenerator pGen = new PKCS5S2ParametersGenerator(new SHA256Digest());
    pGen.init(Strings.toByteArray("password"), salt, 2048);
    KeyParameter key = (KeyParameter)pGen.generateDerivedParameters(256);
    System.out.println(Hex.toHexString(key.getKey()));