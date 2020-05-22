SearchResponse response = client.prepareSearch(ENTITY_INDEX_NAME)
            .setTypes(ENTITY_TYPE_NAME)
            .addFields("field1", "field2") //fields
            .setSearchType(SearchType.QUERY_AND_FETCH)
            .setQuery(qb)
            .setFrom(0)
            .addSort("line_id", SortOrder.ASC)
            .setSize(MAX_SIZE_OF_ENTITIES_TO_RETURN)
            .execute().actionGet();