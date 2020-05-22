public static PrivateKey getPemPrivateKey(String mKey) throws Exception {
    PEMParser pemParser = new PEMParser(new StringReader(mKey));
    final PEMKeyPair pemKeyPair = (PEMKeyPair) pemParser.readObject();
    final byte[] encoded = pemKeyPair.getPrivateKeyInfo().getEncoded();
    KeyFactory kf = KeyFactory.getInstance("RSA");
    return kf.generatePrivate(new PKCS8EncodedKeySpec(encoded));

}