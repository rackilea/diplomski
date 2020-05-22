// create the search request
SearchRequest searchRequest = new SearchRequest(INDEX); 
searchRequest.types(TYPE);

// create the match query on the author field
SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("author", "JournalDev"); 
searchSourceBuilder.query(matchQueryBuilder); 
searchRequest.source(searchSourceBuilder);

// send the request
SearchResponse searchResponse = restHighLevelClient.search(searchRequest);

// read the response
SearchHit[] searchHits = searchResponse.getHits().getHits();
for (SearchHit hit : searchHits) {
    // get each hit as a Map
    Map<String, Object> sourceAsMap = hit.getSourceAsMap();
    String documentTitle = (String) sourceAsMap.get("title");
    ...
}