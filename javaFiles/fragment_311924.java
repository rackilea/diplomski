QueryBuilder queryBuilder = boolQuery() .must(QueryBuilders.termQuery("name", "")) .must(QueryBuilders.termQuery("alias", ""));



        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("your index");
        searchRequestBuilder.setQuery(queryBuilder);


        SearchResponse response = searchRequestBuilder.execute().actionGet();


        System.out.println(response.getHits().getTotalHits());
        for (SearchHit hit : response.getHits()){
            list.add(hit.getSourceAsString());
        }