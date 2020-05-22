Config cfg = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();
Driver driver = GraphDatabase.driver("bolt://10.209.20.211:7687",
        AuthTokens.basic("username", "xxxx"), cfg);
System.out.println("neo4j driver created..");
Session session = driver.session();
System.out.println("session opened..");