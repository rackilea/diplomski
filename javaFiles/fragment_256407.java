public interface WindowsPRNG {

    static void init() {
        String provider = "SunMSCAPI"; // original provider
        String type = "SecureRandom"; // service type
        String alg = "Windows-PRNG"; // algorithm
        String name = String.format("%s.%s", provider, type); // our provider name
        if (Security.getProvider(name) != null) return; // already registered
        Optional.ofNullable(Security.getProvider(provider)) // only on Windows
                .ifPresent(p-> Optional.ofNullable(p.getService(type, alg)) // should exist but who knows?
                        .ifPresent(svc-> Security.insertProviderAt( // insert our provider with single SecureRandom service
                                new Provider(name, p.getVersion(), null) {{
                                    setProperty(String.format("%s.%s", type, alg), svc.getClassName());
                                }}, 1)));
    }

}