QueryBuilder qb = QueryBuilders
            .rangeQuery("price")
            .from(minPrice)
            .to(maxPrice)
            .includeLower(true)
            .includeUpper(true);

    SearchRequest searchRequest = new SearchRequest(INDEXTOUR); 
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
    searchSourceBuilder.query(qb); 
    searchRequest.types(TYPETOUR);
    searchRequest.source(searchSourceBuilder); 

    SearchResponse searchResponse = null;
    try {
        searchResponse = restHighLevelClient.search(searchRequest);
    } catch (java.io.IOException e) {
        e.printStackTrace();
        e.getLocalizedMessage();
    }