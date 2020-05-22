JSONObject obj = (JSONObject)JSONValue.parse(jsonString);
for (Object key : obj.keySet()) {
    Object value = obj.get(key);
    System.out.printf("key %s(%s)\nvalue %s(%s)\n\n",
           key.getClass().getSimpleName(),
           key,
           value.getClass().getSimpleName(),
           value);
}