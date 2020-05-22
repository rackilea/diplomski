void testKeyDerivation(ECPublicKey otherPublic, byte[] salt) throws Exception{
    // create some keypair, which fits to the EC key, IAIK is using:        
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
    keyGen.initialize(otherPublic.getParams());
    KeyPair testKeyPair = keyGen.generateKeyPair();
    ECPublicKey publicTestKey = (ECPublicKey) testKeyPair.getPublic();

    // convert the JCE Publickey to the required format, using BouncyCastle:
    byte[] encodedPublicTestKey = EC5Util.convertPoint(publicTestKey.getParams(), publicTestKey.getW(),false).getEncoded(false);
    // format is 0x04 X Y where X and Y are byte[], containing the (padded) coordinates of the point, 
    // specifying the public key    


    // in fact, you need to do only one of these, but I want to show, how both works:
    byte[] iaikDerivedKey =  deriveKey(encodedPublicTestKey, salt, DHKeyDerivationParameters.KeyDerivationFunctionType.SHA1_KDF);
    byte[] iaikDerivedSecret =  getSharedSecret(encodedPublicTestKey);


    // verify that both sides indeed agree:
    KeyAgreement ka = KeyAgreement.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
    ka.init(testKeyPair.getPrivate());
    ka.doPhase(otherPublic, true);
    byte [] secret = ka.generateSecret();

    Assert.assertTrue(Arrays.equals(iaikDerivedSecret,  secret));

    Digest digest = new SHA1Digest();
    KDF2BytesGenerator kdf = new KDF2BytesGenerator(digest);
    DerivationParameters derivationParameters = new KDFParameters(secret,salt);

    kdf.init(derivationParameters);
    byte[] derivedKey = new byte[iaikDerivedKey.length];
    kdf.generateBytes(derivedKey, 0, iaikDerivedKey.length);
    Assert.assertTrue(Arrays.equals(iaikDerivedKey,  derivedKey));
}