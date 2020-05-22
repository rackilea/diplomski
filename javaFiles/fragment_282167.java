public void resetStatistics(String entityId) {
    if (client.admin().indices().exists(new IndicesExistsRequest(ES_INDEX_NAME)).actionGet().isExists()) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        try {
            logger.info("Elasticsearch cleaning task execution started");

            SearchResponse scrollResp = client.prepareSearch(ES_INDEX_NAME)
                    .setTypes(ES_RECORD_TYPE)
                    .setScroll(TIME_VALUE)
                    .setQuery(
                            QueryBuilders.boolQuery()
                                    .filter(QueryBuilders.termQuery(ENTITY_ID, entityId)))
                    .addSort("_doc", SortOrder.ASC)
                    .setNoFields()
                    .setSize(100).execute().actionGet();

            while (true) {
                for (SearchHit hit : scrollResp.getHits().getHits()) {
                    bulkRequest.add(client.prepareDelete()
                            .setIndex(ES_INDEX_NAME)
                            .setType(ES_RECORD_TYPE)
                            .setId(hit.getId()));
                }
                scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(TIME_VALUE).execute().actionGet();

                if (scrollResp.getHits().getHits().length == 0) {
                    break;
                }
            }

            if (!bulkRequest.request().requests().isEmpty()) {
                BulkResponse bulkResponse = bulkRequest.execute().actionGet();
                if (bulkResponse.hasFailures()) {
                    logger.error("Elasticsearch cleaning task execution failed");
                } else {
                    logger.info("Elasticsearch cleaning task finished execution deleting {} documents", bulkResponse.getItems().length);
                }
            } else {
                logger.info("Elasticsearch cleaning task finished execution without deleting any documents");
            }
        } catch (Exception e) {
           logger.error("Unable to delete data", e);
        }

        try {
            logger.info("Elasticsearch index optimization started");

            ForceMergeResponse forceMergeResponse = client.admin().indices()
                    .prepareForceMerge(ES_INDEX_NAME)
                    .setFlush(true)
                    .setOnlyExpungeDeletes(false)
                    .execute().actionGet();

            logger.info("Elasticsearch index optimization finished with {} successful and {} failed shards out of " +
                    "{} total shards", forceMergeResponse.getSuccessfulShards(), forceMergeResponse.getFailedShards(),
                    forceMergeResponse.getTotalShards());
        } catch (Exception e) {
            logger.error("Error while optimizing Elasticsearch index", e);
        }
    }
}