public static final KeyGenerator getInstance(String algorithm)
        throws NoSuchAlgorithmException {
    if (algorithm == null) {
        throw new NullPointerException("algorithm == null");
    }
    Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
    return new KeyGenerator((KeyGeneratorSpi) sap.spi, sap.provider, algorithm);
}