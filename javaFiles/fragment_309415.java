void sign(InputStream original, OutputStream result, String name, CryptoStandard subfilter,
        int certificationLevel, boolean isAppendMode, byte[] password) throws IOException, GeneralSecurityException {
    String reason = "Just another illusionary reason";
    String location = "Right around the corner";
    boolean setReuseAppearance = false;
    String digestAlgorithm = "SHA512";
    ITSAClient tsc = null;

    PdfReader reader = new PdfReader(original, new ReaderProperties().setPassword(password));
    PdfSigner signer = new PdfSigner(reader, result, isAppendMode);

    signer.setCertificationLevel(certificationLevel);

    // Creating the appearance
    signer.getSignatureAppearance()
          .setReason(reason)
          .setLocation(location)
          .setReuseAppearance(setReuseAppearance);

    signer.setFieldName(name);

    // Creating the signature
    IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
    signer.signDetached(new BouncyCastleDigest(), pks, chain, null, null, tsc, 0, subfilter);
}