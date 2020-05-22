Signature signature = Signature.getInstance("SHA256withRSA", new BouncyCastleProvider());
byte[] test_data = "test".getBytes();
    signature.initSign(kp.getPrivate());
signature.update(test_data);
CMSTypedData data = new CMSProcessableByteArray(signature.sign());
...
CMSSignedData signedData = gen.generate(data, true);