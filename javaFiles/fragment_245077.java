SearchResponse response = client.prepareSearch(index)
            .setTypes(type)
            .setSearchType(SearchType.QUERY_AND_FETCH)
            .setQuery(QueryBuilders.termQuery("country", "turkey"))
            .setFrom(0).setSize(60).setExplain(true)
            .execute()
            .actionGet();