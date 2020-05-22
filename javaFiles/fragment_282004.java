public void setSigningKey(String key) {
    Assert.hasText(key);
    key = key.trim();

    this.signingKey = key;

    if (isPublic(key)) {
        signer = new RsaSigner(key);
        logger.info("Configured with RSA signing key");
    }
    else {
        // Assume it's a MAC key
        this.verifierKey = key;
        signer = new MacSigner(key);
    }
}