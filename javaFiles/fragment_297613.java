KieServices kieServices = KieServices.Factory.get();
    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    // Rule from string
    gitRulesDao.getAllRulesFilesFromGitLab().forEach(r -> {
        try {
            addRuleToKie(kieFileSystem, kieServices, fileSystemBaseUrl, r);
        } catch (IOException | GitLabApiException e) {
            e.printStackTrace();
        }
    });

    // build
    KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
    kieBuilder.buildAll();
    // Test rule
    Results results = kieBuilder.getResults();
    if (results.hasMessages(Message.Level.ERROR)) {
         ...
    }
    //
    KieModule kieModule = kieBuilder.getKieModule();
    return new 
    KieContainerLocal(kieServices.newKieContainer(kieModule.getReleaseId()));