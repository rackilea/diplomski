SearchResponse response = client.prepareSearch(index)
        .setTypes(type)
        .setSearchType(SearchType.QUERY_AND_FETCH)
        .setQuery(QueryBuilders.multiMatchQuery(value,
                "name", "address1", "city", "postalCode",
                "countryCode", "airportCode", "locationDescription",
                "shortDescription"
        ))
        .setFrom(0).setSize(100).setExplain(true)
        .execute()
        .actionGet();