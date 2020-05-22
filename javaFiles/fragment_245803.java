SearchQuery searchQuery = new NativeSearchQueryBuilder()
    .withPageable(new PageRequest(1, 5))        <--- add this
    .withQuery(matchAllQuery())
    .withQuery(queryString("A"))                
    .withSort(SortBuilders.fieldSort("fruitId").order(SortOrder.DESC))                
    .withIndices("fruit").withTypes("fruit");