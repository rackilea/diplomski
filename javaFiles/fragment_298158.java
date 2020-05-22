public Result search(String term, String index) {
    // The query 
    String cypherQuery = 
        "CALL db.index.fulltext.queryNodes($index, $term) YIELD node, score\n" + 
        "RETURN id(node), score"; 
    // Execute query
    Map<String, Object> params = new HashMap<>();
    params.put("term", term);
    params.put("index", index);
    return db.execute(cypherQuery, params);
}