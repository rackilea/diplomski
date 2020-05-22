// prepare the bounding box constraint on the location field
QueryBuilder bbox = QueryBuilders.geoBoundingBoxQuery("location") 
    .topLeft(40.73, -74.1)                            
    .bottomRight(40.717, -73.99);
TypeQueryBuilder onlyTypeA = QueryBuilders.typeQuery("type_a");
QueryBuilders bboxTypeA = QueryBuilders.boolQuery()
    .must(bbox)
    .must(onlyTypeA);

// prepare the constraint on the name field
MatchQueryBuilder name = QueryBuilders.matchQuery("name", "xxxx")
TypeQueryBuilder onlyTypeB = QueryBuilders.typeQuery("type_b");
QueryBuilders nameTypeB = QueryBuilders.boolQuery()
    .must(name)
    .must(onlyTypeB);

// prepare the overall OR query
BoolQueryBuilder query = QueryBuilders.boolQuery()
    .should(bboxTypeA)
    .should(nameTypeB)

// create the request and execute it
SearchResponse response = client.prepareSearch("records")
    .setTypes("type_a", "type_b")
    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    .setQuery(query)
    .execute()
    .actionGet();