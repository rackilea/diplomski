static <T> T stringToObject(String jsonString, Class<T> clazz) {
  ObjectMapper mapper = new ObjectMapper();
  return mapper.readValue(jsonString, clazz);
}

static void test() {
   Foo foo = stringToObject("...", Foo.class);
}