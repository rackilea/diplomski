// brand list
BoolQueryBuilder query = QueryBuilders.boolQuery();
for (String key : brands) {
    query.must(QueryBuilders.matchQuery("brand", key));
}

// search term
query.must(QueryBuilders.matchPhraseQuery("name", pSearchTerm));

// price range
query.filter(QueryBuilders.rangeQuery("unit_price").from(min).to(max));

SearchResponse searchresponse = client
    .prepareSearch("product")
    .setTypes("product")
    .setQuery(query)
    .setExplain(true)
    .execute().actionGet();