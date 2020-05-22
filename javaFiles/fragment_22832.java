public final PublicKey generatePublic(KeySpec keySpec)
        throws InvalidKeySpecException {
    if (serviceIterator == null) {
        return spi.engineGeneratePublic(keySpec);
    }
    // Truncated for brevity
}