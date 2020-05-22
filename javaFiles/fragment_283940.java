Set<String> supportedKeyPairAlgorithms() {
    Set<String> algos = new HashSet<>();
    for (Provider provider : Security.getProviders()) {
        for (Provider.Service service : provider.getServices()) {
            if ("KeyPairGenerator".equals(service.getType())) {
                algos.add(service.getAlgorithm());
            }
        }
    }
    return algos;
}