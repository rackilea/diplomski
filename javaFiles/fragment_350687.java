public static PrivateKey getPrivateKeyFromECBigIntAndCurve(BigInteger s, String curveName) {
    X9ECParameters ecCurve = ECNamedCurveTable.getByName(curveName);
    ECParameterSpec ecParameterSpec = new ECNamedCurveSpec(curveName, ecCurve.getCurve(), ecCurve.getG(), ecCurve.getN(), ecCurve.getH(), ecCurve.getSeed());
    ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(s, ecParameterSpec);
    try {
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        return keyFactory.generatePrivate(privateKeySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        e.printStackTrace();
        return null;
    }
}