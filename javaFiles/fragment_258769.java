SearchRequest searchRequest = new SearchRequest("index-name");
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if (email != null) {
            MatchQueryBuilder emailMatchQueryBuilder = new MatchQueryBuilder("emailId", email);
            boolQueryBuilder.must(emailMatchQueryBuilder);
        }
SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);
        log.info("Search json {} for user exist", searchSourceBuilder.toString()); --> you can check the ES search json generated.
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = esclient.search(searchRequest, RequestOptions.DEFAULT);