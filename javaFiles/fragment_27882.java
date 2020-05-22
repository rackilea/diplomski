public KieSession createJPASession(final String kieBaseId, Optional<String> clockType, Optional<String> beliefSystem) {
    log.info(String.format("Creating JPA Session for kieBase %s, clockType %s, beliefSystem %s", kieBaseId, clockType, beliefSystem));
    KieBase kieBase = kContainer.getKieBase(kieBaseId);
    KieSessionConfiguration ksConf = ks.newKieSessionConfiguration();

    // Set this thing up manually. Looking at the impl/docs these are the only two options available to set.
    // The Storage service will remove those options from a default session for whatever reason, however we can set this manually
    // This means we can use the base configuration and have things run in a normal way

    if (clockType.isPresent()) {
        ksConf.setOption(ClockTypeOption.get(clockType.get()));
    }
    if (beliefSystem.isPresent()) {
        ksConf.setOption(BeliefSystemTypeOption.get(beliefSystem.get()));
    }

    KieSession jpaSession = ks.getStoreServices().newKieSession(kieBase, ksConf, env);
    sessions.put(jpaSession.getIdentifier(), jpaSession);
    return jpaSession;
}