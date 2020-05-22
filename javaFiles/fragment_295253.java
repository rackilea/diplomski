public static byte[] signer(byte[] data, PrivateKey key) {
    Signature signer = Signature.getInstance("SHA256WithRSA", "BC");
    signer.initSign(key);
    signer.update(data);
    return signer.sign();
}