QueryBuilder query = QueryBuilders.queryStringQuery("*357* AND account_id:574fe92c9179a809fd76f0b8 AND invalid:false");
SearchResponse response = esClient.prepareSearch(SecurityManager.getNamespace())
        .addSort("created_time", SortOrder.DESC)
        .setTypes(dataType)
        .setQuery(query)
        .addFields("_id")
        .setFrom(page * size)
        .setSize(size)
        .setExplain(false)
        .execute()
        .actionGet();