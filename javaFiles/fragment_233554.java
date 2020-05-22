@Test
public void apply_map_to_existing_object_via_json() throws Exception {
    ExampleRecord record = new ExampleRecord();
    Map<String, Object> properties = ImmutableMap.of("firstProperty", "foo", "secondProperty", "bar");

    TokenBuffer buffer = new TokenBuffer(mapper, false);
    mapper.writeValue(buffer, properties);
    mapper.readerForUpdating(record).readValue(buffer.asParser());

    assertThat(record.firstProperty, equalTo("foo"));
    assertThat(record.secondProperty, equalTo("bar"));
}