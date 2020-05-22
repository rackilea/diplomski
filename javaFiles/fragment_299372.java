private void yourMethod() {
    String request = "START sdg=node:Sfamilly({luceneQuery}) MATCH t-[CONTAINS_SF]->sdg RETURN count(distinct t) as count";

    Map<String, Object> params = new HashMap<String, Object>();
    List<String> codes = new ArrayList<String>();
    codes.add("1234");
    codes.add("12345");
    params.put("luceneQuery", listToParams("master", codes));

    Result<Map<String, Object>> resultMag = neo4jTemplate.query(request, params);
}

private String listToParams(String paramName, List<String> params) {
    if (params.isEmpty()) {
        throw new IllegalArgumentException("Empty params");
    }

    Iterator<String> paramsIterator = params.iterator();
    StringBuilder builder = new StringBuilder(paramName).append(":").append(paramsIterator.next());

    while (paramsIterator.hasNext()) {
        builder.append(" OR ").append(paramName).append(":").append(paramsIterator.next());
    }

    return builder.toString();
}