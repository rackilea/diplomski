Settings settings = ImmutableSettings
            .settingsBuilder()
            .put("cluster.name", "es_cluster_name"))
            // Define similarity module settings
            .put("similarity.custom.type", "BM25")
            .put("similarity.custom.k1", 2.0f)
            .put("similarity.custom.b", 1.5f)
            .build();

Client client = new TransportClient(settings);