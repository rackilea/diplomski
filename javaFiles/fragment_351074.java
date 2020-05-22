public static boolean jsonEquals(String json1, String json2, String... ignoreKeys) throws IOException {
    // this is a Guava Predicate
    Predicate<String> filter = Predicates.not(Predicates.in(Sets.newHashSet(ignoreKeys)));

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> object1 = Maps.filterKeys(mapper.readValue(json1, Map.class), filter);
    Map<String, Object> object2 = Maps.filterKeys(mapper.readValue(json2, Map.class), filter);
    return object1.equals(object2);
}