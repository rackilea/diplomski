public Boolean VerifyDigital(String data, byte[] sigData) throws Exception, NoSuchAlgorithmException {

    DigitalSignature ac = new DigitalSignature();
    Signature signature = Signature.getInstance("SHA1withRSA");
    signature.initVerify(ac.getPublic("KeyPair/publicKey"));
    signature.update(data.getBytes("UTF-8"));
    Boolean ok = signature.verify(sigData);
    return ok;
}