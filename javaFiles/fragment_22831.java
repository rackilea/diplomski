private KeyFactory(String algorithm) throws NoSuchAlgorithmException {
    this.algorithm = algorithm;
    List<Service> list = GetInstance.getServices("KeyFactory", algorithm);
    serviceIterator = list.iterator();
    // fetch and instantiate initial spi
    if (nextSpi(null) == null) {
        throw new NoSuchAlgorithmException
            (algorithm + " KeyFactory not available");
    }
}