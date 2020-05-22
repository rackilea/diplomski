@Test
public void testJackson() {
    ObjectMapper jsonMapper = new ObjectMapper();
    jsonMapper.registerModule(new MyModule(jsonMapper.getDeserializationConfig()));
    String json = "{\"id\": \"1\"}";
    try {
        Q q = jsonMapper.readValue(json, Q.class);
        System.out.println(q.getId());
    } catch (JsonMappingException e) {
        System.out.println(e.getCause()); //java.lang.RuntimeException: ex 2
    } catch (JsonParseException e) {
    } catch (IOException e) {
    }
}