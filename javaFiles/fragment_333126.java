KnowledgeBuilderConfiguration kbConfig =
        KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();

    kbConfig.setProperty("drools.dialect.mvel.strict", "false");

    KnowledgeBuilder kBuilder =
        KnowledgeBuilderFactory.newKnowledgeBuilder( kbConfig );