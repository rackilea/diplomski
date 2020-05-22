private static byte[] toDerSignature(byte[] jwsSig) throws IOException {

    byte[] rBytes = Arrays.copyOfRange(jwsSig, 0, 32);
    byte[] sBytes = Arrays.copyOfRange(jwsSig, 32, 64);

    BigInteger r = new BigInteger(1, rBytes);
    BigInteger s = new BigInteger(1, sBytes);

    DERSequence sequence = new DERSequence(new ASN1Encodable[] {
            new ASN1Integer(r),
            new ASN1Integer(s)
    });

    return sequence.getDEREncoded();
}