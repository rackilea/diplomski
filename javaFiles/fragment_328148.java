KeyPairGenerator eckpg = KeyPairGenerator.getInstance("EC");
ECGenParameterSpec p256 = new ECGenParameterSpec("secp256r1");
eckpg.initialize(p256);
KeyPair doubleUseKeyPair = eckpg.generateKeyPair();
KeyAgreement ecdh = KeyAgreement.getInstance("ECDH");
ecdh.init(doubleUseKeyPair.getPrivate());
// ...

Signature ecdsa = Signature.getInstance("SHA256withECDSA");
ecdsa.initSign(doubleUseKeyPair.getPrivate());
// ...

System.out.println(eckpg.getProvider());
System.out.println(ecdh.getProvider());
System.out.println(ecdsa.getProvider());