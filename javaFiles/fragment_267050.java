XContentBuilder xbMapping =
        jsonBuilder()
                .startObject()
                .startObject(indexType)
                .startObject("properties")
                .startObject("source")
                .field("type", "string")
                .endObject()
                .startObject("text")
                .field("type", "string")
                .field("analyzer", JAPANESE_LANGUAGE_ANALYSIS)
                .endObject()
                .endObject()
                .endObject()
                .endObject();

elasticSearchClient.admin().indices()
        .preparePutMapping(indexName)
        .setType(indexType)
        .setSource(xbMapping)
        .execute().get();