MongoCredential credential = MongoCredential.createCredential("user", "admin", "mypassword".toCharArray());
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .retryWrites(true)
                .applyToConnectionPoolSettings(builder ->
                        builder.maxConnectionIdleTime(5000, TimeUnit.MILLISECONDS))
                .applyToSslSettings(builder -> builder.enabled(true))
                .applyToClusterSettings(builder -> {
                    builder.hosts(Arrays.asList(
                            new ServerAddress("cluster0-shard-00-00-ox90k.mongodb.net", 27017),
                            new ServerAddress("cluster0-shard-00-01-ox90k.mongodb.net", 27017),
                            new ServerAddress("cluster0-shard-00-02-ox90k.mongodb.net", 27017)
                    ));
                    builder.requiredReplicaSetName("Cluster0-shard-0");
                })
                .build();

        MongoClient mongoClient = MongoClients.create(settings);