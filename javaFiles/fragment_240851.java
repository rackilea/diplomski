TreeSet<String> algorithms = new TreeSet<>();
for (Provider provider : Security.getProviders())
    for (Service service : provider.getServices())
        if (service.getType().equals("Signature"))
            algorithms.add(service.getAlgorithm());
for (String algorithm : algorithms)
    System.out.println(algorithm);