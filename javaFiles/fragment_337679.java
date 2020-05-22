// Set the query parameters
Map<String, Object> bindVars
    = new MapBuilder()
    .put("startVertex", "nodes/1234")
    .put("targetVertex", "nodes/5678")
    .get();

// execute the query
ArangoCursor<BaseDocument> cursor = arango.db("mydb").query(
    "FOR v IN ANY SHORTEST_PATH "
        + "@startVertex TO @targetVertex "
        + "edges "
        + "OPTIONS { weightAttribute: 'weight' } "
        + "RETURN v",
    bindVars,
    null,
    BaseDocument.class
);

// do something with the results
cursor.forEach((v) -> {
    System.out.println(v);
});