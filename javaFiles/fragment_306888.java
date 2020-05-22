try (   InputStream resource = INTERMEDIATE_INPUT_STREAM;
        OutputStream os = RESULT_STREAM) {
    PdfReader reader = new PdfReader(resource);
    PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');

    PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
    appearance.setReason("reason");
    appearance.setLocation("location");
    appearance.setCertificationLevel(PdfSignatureAppearance.CERTIFIED_NO_CHANGES_ALLOWED);
    appearance.setVisibleSignature("Signature");

    ExternalSignature pks = new PrivateKeySignature(pk, "SHA512", "BC");
    ExternalDigest digest = new BouncyCastleDigest();
    MakeSignature.signDetached(appearance, digest, pks, chain, null, null, null, 0, CryptoStandard.CMS);
}