SearchQuery searchQuery = new NativeSearchQueryBuilder()
        .withQuery(QueryBuilders.matchQuery("activity", "TAG_SEARCH"))
        .withSearchType(COUNT)
        .withIndices("user_activity")
        .withTypes("user_activity")
        .addAggregation(AggregationBuilders.terms("tags").field("tag"));