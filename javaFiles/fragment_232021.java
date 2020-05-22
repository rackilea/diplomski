public static List<String> getDistinctAgg(TransportClient client, String indexName, String fieldName, int requiredSize) {
    List<String> values = new LinkedList<>();

    try {


        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder(fieldName + "_Agg", ValueType.STRING);
        aggregationBuilder.field(fieldName);
        aggregationBuilder.bucketCountThresholds(new TermsAggregator.BucketCountThresholds(1, 1, requiredSize, 5));

        QueryBuilder query = QueryBuilders.matchAllQuery();


        SearchResponse response = client.prepareSearch(indexName)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(query).addAggregation(aggregationBuilder).setSize(0).get();
        if (response == null) return null;

        StringTerms terms = ((StringTerms) response.getAggregations().get(fieldName + "_Agg"));

        if (terms != null) {

            List<Terms.Bucket> buckets = terms.getBuckets();
            if (buckets != null && buckets.size() > 0) {


                for (Terms.Bucket bucket : buckets) {
                    values.add(bucket.getKeyAsString());
                }
            }
            return values;
        }

    } catch (Exception e) {
        return null;
    }
    return null;
}