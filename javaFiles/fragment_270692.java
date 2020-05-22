private void deleteAllByQuery(final String index, final String type, final QueryBuilder query) {
    SearchResponse response = elasticSearchClient.prepareSearch(index)
            .setTypes(type)
            .setQuery(query)
            .setSize(Integer.MAX_VALUE)
            .execute().actionGet();

    SearchHit[] searchHits = response.getHits().getHits();

    while (searchHits.length > 0) {
        LOGGER.debug("Need to delete " + searchHits.length + " records");

        // Create bulk request
        final BulkRequestBuilder bulkRequest = elasticSearchClient.prepareBulk().setRefresh(true);

        // Add search results to bulk request
        for (final SearchHit searchHit : searchHits) {
            final DeleteRequest deleteRequest = new DeleteRequest(index, type, searchHit.getId());
            bulkRequest.add(deleteRequest);
        }

        // Run bulk request
        final BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            LOGGER.error(bulkResponse.buildFailureMessage());
        }

        // After deleting, we should check for more records
        response = elasticSearchClient.prepareSearch(index)
            .setTypes(type)
            .setQuery(query)
            .setSize(Integer.MAX_VALUE)
            .execute().actionGet();

        searchHits = response.getHits().getHits();
    }
}