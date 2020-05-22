public KnowledgeBase newKBase(URLClassLoader loader) {

    KnowledgeBuilderConfiguration kbuilderConfig =
        KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration(null, loader);
    // Create the agent using the builder configuration
    KnowledgeAgentConfiguration aconf = KnowledgeAgentFactory.newKnowledgeAgentConfiguration();
    KnowledgeBaseConfiguration kbaseConfig = KnowledgeBaseFactory.newKnowledgeBaseConfiguration(null, loader);
    KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(kbaseConfig);
    KnowledgeAgent kagent =
        KnowledgeAgentFactory.newKnowledgeAgent(knowledgeAgentName, kbase, aconf, kbuilderConfig);
    kbase = kagent.getKnowledgeBase();
    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(kbuilderConfig);

    addRules(kbuilder);
    KnowledgeBuilderErrors errors = kbuilder.getErrors();

    if (errors.size() > 0) {
        for (KnowledgeBuilderError error : errors)
            System.err.println(error);
        throw new IllegalArgumentException("Could not parse knowledge.");
    }

    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

    return kbase;
}