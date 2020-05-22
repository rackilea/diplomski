SearchRequest searchRequest = new SearchRequest(INDEX);
    searchRequest.types(TYPE);          
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    searchSourceBuilder.query(QueryBuilders.matchAllQuery());

    AggregationBuilder aggregation=AggregationBuilders.terms("source_aggs")
                .field("source.keyword").size(size)
                .order(BucketOrder.count(isAscending));

    searchSourceBuilder.aggregation(aggregation);

    searchRequest.source(searchSourceBuilder);
    SearchResponse searchResponse =restHighLevelClient.search(searchRequest);
    Aggregation aggrega = searchResponse.getAggregations().get("source_aggs");
    StringTerms st = (StringTerms) aggrega;
    System.out.println(searchResponse);