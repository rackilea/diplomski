SearchResponse response = transportClient
        //.prepareSearch(ChatSettings.ELASTIC_LAST_SEEN_INDEX_NAME) // you might need to pass the columns here
        .setTypes(ChatSettings.ELASTIC_DB_NAME)
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        .setFetchSource(new String[]{"id","lastSeenTime"}, null) // or you can pass the columns here
        .setQuery(QueryBuilders.idsQuery().addIds(ssoIds)) // where ssoIds is a array of Ids        
        .setFrom(0).setSize(1).setExplain(true)
        .get();