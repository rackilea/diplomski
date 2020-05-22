private PublicKey getPublicKeyFromBytes(byte[] pubKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
    ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("prime256v1");
    KeyFactory kf = KeyFactory.getInstance("ECDSA", new BouncyCastleProvider());
    ECNamedCurveSpec params = new ECNamedCurveSpec("prime256v1", spec.getCurve(), spec.getG(), spec.getN());
    ECPoint point =  ECPointUtil.decodePoint(params.getCurve(), pubKey);
    ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(point, params);
    ECPublicKey pk = (ECPublicKey) kf.generatePublic(pubKeySpec);
    return pk;
}