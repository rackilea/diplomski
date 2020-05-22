public KieSession newKieSession(String kSessionName, Environment environment, KieSessionConfiguration conf) {
    KieSessionModelImpl kSessionModel = (KieSessionModelImpl) getKieSessionModel(kSessionName);
    if ( kSessionModel == null ) {
        log.error("Unknown KieSession name: " + kSessionName);
        return null;
    }
    if (kSessionModel.getType() == KieSessionModel.KieSessionType.STATELESS) {
        throw new RuntimeException("Trying to create a stateful KieSession from a stateless KieSessionModel: " + kSessionName);
    }
    KieBase kBase = getKieBase( kSessionModel.getKieBaseModel().getName() );
    if ( kBase == null ) {
        log.error("Unknown KieBase name: " + kSessionModel.getKieBaseModel().getName());
        return null;
    }

    KieSession kSession = kBase.newKieSession( conf != null ? conf : getKnowledgeSessionConfiguration(kSessionModel), environment );
    wireListnersAndWIHs(kSessionModel, kSession);
    registerLoggers(kSessionModel, kSession);
    kSessions.put(kSessionName, kSession);
    return kSession;
}