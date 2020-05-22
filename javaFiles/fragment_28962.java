// build the query
BoolQueryBuilder query = QueryBuilders.boolFilter()
    .must(QueryBuilders.termFilter("code", "18"));

// build the terms sub-aggregation
TermsAggregation stateAgg = AggregationBuilders.terms("group_by_state")
    .field("id");

SearchResponse resp = client.prepareSearch("sweet")
        .setType("cake")
        .setQuery(query)
        .setSize(0)
        .addAggregation(stateAgg)
        .execute()
        .actionGet();