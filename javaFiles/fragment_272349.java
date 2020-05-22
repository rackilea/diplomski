...
        } else if (type.startsWith("ecdsa-sha2-") &&
                (type.endsWith("nistp256") || type.endsWith("nistp384") || type.endsWith("nistp521"))) {
            // Based on RFC 5656, section 3.1 (https://tools.ietf.org/html/rfc5656#section-3.1)
            String identifier = decodeType();
            BigInteger q = decodeBigInt();
            ECPoint ecPoint = getECPoint(q, identifier);
            ECParameterSpec ecParameterSpec = getECParameterSpec(identifier);
            ECPublicKeySpec spec = new ECPublicKeySpec(ecPoint, ecParameterSpec);
            return KeyFactory.getInstance("EC").generatePublic(spec);
        } ...

/**
 * Provides a means to get from a parsed Q value to the X and Y point values.
 * that can be used to create and ECPoint compatible with ECPublicKeySpec.
 *
 * @param q          According to RFC 5656:
 *                   "Q is the public key encoded from an elliptic curve point into an octet string"
 * @param identifier According to RFC 5656:
 *                   "The string [identifier] is the identifier of the elliptic curve domain parameters."
 * @return An ECPoint suitable for creating a JCE ECPublicKeySpec.
 */
ECPoint getECPoint(BigInteger q, String identifier) {
    String name = identifier.replace("nist", "sec") + "r1";
    ECNamedCurveParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec(name);
    org.bouncycastle.math.ec.ECPoint point = ecSpec.getCurve().decodePoint(q.toByteArray());
    BigInteger x = point.getAffineXCoord().toBigInteger();
    BigInteger y = point.getAffineYCoord().toBigInteger();
    System.out.println("BC x = " + x);
    System.out.println("BC y = " + y);
    return new ECPoint(x, y);
}

/**
 * Gets the curve parameters for the given key type identifier.
 *
 * @param identifier According to RFC 5656:
 *                   "The string [identifier] is the identifier of the elliptic curve domain parameters."
 * @return An ECParameterSpec suitable for creating a JCE ECPublicKeySpec.
 */
ECParameterSpec getECParameterSpec(String identifier) {
    try {
        // http://www.bouncycastle.org/wiki/pages/viewpage.action?pageId=362269#SupportedCurves(ECDSAandECGOST)-NIST(aliasesforSECcurves)
        String name = identifier.replace("nist", "sec") + "r1";
        AlgorithmParameters parameters = AlgorithmParameters.getInstance("EC");
        parameters.init(new ECGenParameterSpec(name));
        return parameters.getParameterSpec(ECParameterSpec.class);
    } catch (InvalidParameterSpecException | NoSuchAlgorithmException e) {
        throw new IllegalArgumentException("Unable to get parameter spec for identifier " + identifier, e);
    }
}