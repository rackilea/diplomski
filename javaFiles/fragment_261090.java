JsonParser parser = JsonParserFactory.getJsonParser();
Map<String, Object> map = parser.parseMap(str);
Object filterValue = filter.get("<column_name>");
if (filterValue instanceof String) {
  // str is like "{\"<column_name>\":\"<value>\"}"
} else if (filterValue instanceof Collection) {
  for (Object arrayValue : (Collection<Object>) filterValue) {
    if (arrayValue instanceof String) {
      // str is like "{\"<column_name>\":[\"<value1>\",\"<value2>\"]}"
    } else if (arrayValue instanceof Map) {
      // str is like "{\"<column_name>\":[{\"operator\":\"eq\",\"value\":\"<value>\"}]}"
    }
  }
}