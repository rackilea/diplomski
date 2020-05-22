val response = client.prepareSearch("businesses")
    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    .setQuery(text("name", term))
    .setFrom(0).setSize(100).setExplain(true)
    .execute()
    .actionGet();