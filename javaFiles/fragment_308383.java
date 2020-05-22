private static ArrayList<Training> fuzzySearchDocument(Client client, String index, String type, String field, String value, int size, int offset) throws JsonParseException, JsonMappingException, IOException {
     // REFRESH YOUR INDICES (just before searching)
     client().admin().indices().prepareRefresh().execute().actionGet();

     QueryBuilder query = fuzzyQuery(field, value);
     ...