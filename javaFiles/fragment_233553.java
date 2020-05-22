@Test
public void apply_json_to_existing_object() throws Exception {
    ExampleRecord record = new ExampleRecord();
    ObjectReader reader = mapper.readerForUpdating(record)
            .with(JsonParser.Feature.ALLOW_SINGLE_QUOTES)
            .with(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
    reader.readValue("{ firstProperty: 'foo' }");
    reader.readValue("{ secondProperty: 'bar' }");
    assertThat(record.firstProperty, equalTo("foo"));
    assertThat(record.secondProperty, equalTo("bar"));
}

public static class ExampleRecord {
    public String firstProperty;
    public String secondProperty;
}