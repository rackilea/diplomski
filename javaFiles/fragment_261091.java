ObjectMapper mapper = new ObjectMapper();
JsonNode filter = mapper.readTree(str);
JsonNode filterValue = filter.get("<column_name>");
if (filterValue.isTextual()) {
  // str is like "{\"<column_name>\":\"<value>\"}"
} else if (filterValue.isArray()) {
  for (JsonNode arrayValue : filterValue.elements()) {
    if (arrayValue.isTextual()) {
      // str is like "{\"<column_name>\":[\"<value1>\",\"<value2>\"]}"
    } else if (arrayValue.isObject()) {
      // str is like "{\"<column_name>\":[{\"operator\":\"eq\",\"value\":\"<value>\"}]}"
    }
  }
}