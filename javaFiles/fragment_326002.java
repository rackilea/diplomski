@Test
public void serializePersonWithIgnorePropertiesAnnotation() throws JsonProcessingException {
    // set up test data including parent properties
    Person person = makeFakePerson();

    ObjectMapper om = new ObjectMapper();

    // translate object to JSON string using Jackson
    String json = om.writeValueAsString(person);

    assertFalse(json.contains("dbPropertyA"));
    assertFalse(json.contains("dbPropertyB"));
    assertFalse(json.contains("index"));
    System.out.println(json);
}