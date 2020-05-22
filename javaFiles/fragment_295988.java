@Test
public void deserializeImportant() throws IOException {
    ObjectMapper om = new ObjectMapper();
    //note: this has to be present
    om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Important important = om.readValue(getClass().getResourceAsStream("/important.json"), ImportantWrapper.class)
                                .getImportant();

    assertEquals((Integer)123, important.getId());
    assertEquals("foo@foo.com", important.getEmail());
}