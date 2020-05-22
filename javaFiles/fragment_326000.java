@Test
public void serializePersonWithMixIn() throws JsonProcessingException {
    // set up test data including parent properties
    Person person = makeFakePerson();

    // register the mix in
    ObjectMapper om = new ObjectMapper()
            .addMixIn(Person.class, PersonMixIn.class);

    // translate object to JSON string using Jackson
    String json = om.writeValueAsString(person);

    assertFalse(json.contains("dbPropertyA"));
    assertFalse(json.contains("dbPropertyB"));
    assertFalse(json.contains("index"));
    System.out.println(json);
}