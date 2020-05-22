Security.addProvider(new BouncyCastleProvider());

Signature sig = Signature.getInstance("SHA1withRSA/PSS");
sig.initSign(privateKey);
sig.update(data);
byte[] signature = sig.sign();