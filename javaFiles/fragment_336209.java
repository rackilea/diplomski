@Test
public void converts_null_to_null() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree("{\"foo\":null}");
    JsonNode foo = jsonNode.get("foo");

    Set<String> result = mapper.convertValue(foo, new TypeReference<Set<String>>() {});

    assertNull(result);
}