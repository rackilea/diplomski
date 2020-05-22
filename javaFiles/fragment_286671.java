String query =  "((\"PUT\" OR \"POST\") AND \"REST\" AND (\"BRI\" OR 
 \"BRIEXT\" OR \"TMP\"))";

QueryBuilder matchQueryBuilder = QueryBuilders.boolQuery().must(new 
QueryStringQueryBuilder(query));
SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
searchSourceBuilder.query(matchQueryBuilder);

SearchRequest searchRequest = new SearchRequest();
// set the indices you want to search in.
searchRequest.indices("your-index");
searchRequest.source(searchSourceBuilder);

// execute the query
SearchResponse response = hlRestClient.search(searchRequest, header);
SearchHits hits = response.getHits();