PrivateKey generatePrivateKey(String b64) {
    byte[] bytes = Base64.getDecoder().decode(b64);
    for (String algorithm : supportedKeyPairAlgorithms()) {
        try {
            LOGGER.debug("Attempting to decode key as " + algorithm);
            return KeyFactory.getInstance(algorithm).generatePrivate(new PKCS8EncodedKeySpec(bytes));
        } catch (NoSuchAlgorithmException e) {
            LOGGER.warn("Standard algorithm " + algorithm + " not known by this Java runtime from outer space", e);
        } catch (InvalidKeySpecException e) {
            LOGGER.debug("So that key is not " + algorithm + ", nevermind", e);
        }
    }
    throw new RuntimeException("No standard KeyFactory algorithm could decode your key");
}