ObjectMapper mapper = new ObjectMapper();
mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

List<T> objects = new ArrayList<>();
// At this point I only have an variable with a reference to a classe. Let's assume it is in fact a reference to Pojo class
Class VARIABLE_WITH_REFERENCE_TO_A_CLASS = Pojo.class;
Class pojoReference = VARIABLE_WITH_REFERENCE_TO_A_CLASS;
String json = EXAMPLE_JSON_HERE;
JSONArray jsonArray = new JSONArray(json);
int len = jsonArray.length();
for (int i = 0; i < len; i++) {
    objects.add(mapper.readValue(new JSONObject(json).toString(), pojoReference));
}