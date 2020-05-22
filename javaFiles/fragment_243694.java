@Test
public void shouldConvertJSONStringIntoPojo() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    MongoObject actual = mapper.readValue("{\n" +
                                     "        \"userID\" : \"aap\" ,\n" +
                                     "        \"appID\" : \"noot\" ,\n" +
                                     "        \"message\" : \"JSON\" ,\n" +
                                     "        \"session\" : \"ea944555b5ea8ea6\" ,\n" +
                                     "        \"_id\" : { \"$oid\" : \"5245f1063004348555e54815\"}\n" +
                                     "}", MongoObject.class);

    assertThat(actual, equalTo(new MongoObject("5245f1063004348555e54815", "aap", "noot", "JSON", "ea944555b5ea8ea6")));
}