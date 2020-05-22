Map<String,List<Map<String,String>>> result = new JSONDeserializer<Map<String,List<Map<String,String>>>>()
    .use("values",List.class)
    .use("values.values", Map.class)
    .deserialize( json);

List<Map<String,String>> filterEntries = result.get("filterEntries");