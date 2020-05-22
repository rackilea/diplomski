public static void main(String[] args) {
KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator
    .getInstance("DH");
paramGen.init(1024);

// Generate the parameters
AlgorithmParameters params = paramGen.generateParameters();
DHParameterSpec dhSpec = (DHParameterSpec) params
    .getParameterSpec(DHParameterSpec.class);

keyGen.initialize(dhSpec);

KeyPair alice_key = keyGen.generateKeyPair();
KeyPair bob_key = keyGen.generateKeyPair();

SecretKey secret_alice = combine(alice_key.getPrivate(),
    bob_key.getPublic());

SecretKey secret_bob = combine(bob_key.getPrivate(),
    alice_key.getPublic());

System.out.println(Arrays.toString(secret_alice.getEncoded()));
System.out.println(Arrays.toString(secret_bob.getEncoded()));
}

private static SecretKey combine(PrivateKey private1,
    PublicKey public1)  {
KeyAgreement ka = KeyAgreement.getInstance("DH");
ka.init(private1);
ka.doPhase(public1, true);
SecretKey secretKey = ka.generateSecret("DES");
return secretKey;
}