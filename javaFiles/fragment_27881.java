private KieSessionConfiguration getKnowledgeSessionConfiguration(KieSessionModelImpl kSessionModel) {
    KieSessionConfiguration ksConf = KnowledgeBaseFactory.newKnowledgeSessionConfiguration();
    ksConf.setOption( kSessionModel.getClockType() );
    ksConf.setOption( kSessionModel.getBeliefSystem() );
    return ksConf;
}