Security.addProvider(new BouncyCastleProvider());

KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");
kpg.initialize(384);
KeyPair kp = kpg.generateKeyPair();
PublicKey genPub = kp.getPublic();

byte[] enc = genPub.getEncoded();

KeyFactory kf = KeyFactory.getInstance("RSA", "BC");
X509EncodedKeySpec ks = new X509EncodedKeySpec(enc);
PublicKey decPub = kf.generatePublic(ks);

Signature sig = Signature.getInstance("SHA1withRSA", "BC");
sig.initVerify(decPub);
byte[] faultySig = new byte[384 / Byte.SIZE];
boolean verifies = sig.verify(faultySig);

System.out.println(verifies + " for " + decPub.getAlgorithm());