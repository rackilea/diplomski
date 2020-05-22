public void testSimple() throws NoSuchAlgorithmException {
    MyKeyPairGenerator x = new MyKeyPairGenerator();
    x.initialize(40, new SecureRandom("password".getBytes()));

    MyPublicPrivateKey keypair = x.generateKeyPair();
    System.out.println(keypair);

    BigInteger message = new BigInteger("167890871234");
    BigInteger encoded = message.modPow(keypair.e, keypair.n);
    System.out.println(encoded); //gives some encoded value
    BigInteger decoded = encoded.modPow(keypair.d, keypair.n);
    System.out.println(decoded); //gives back original value
}