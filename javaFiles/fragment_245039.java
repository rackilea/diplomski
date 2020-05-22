Settings indexSettings = ImmutableSettings.settingsBuilder()
                 .put("number_of_shards", 5)
                 .put("number_of_replicas", 1)
                 .build();
CreateIndexRequest indexRequest = new CreateIndexRequest("facebook", indexSettings);
client.admin().indices().create(indexRequest).actionGet();