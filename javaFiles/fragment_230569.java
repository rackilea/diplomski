@Test public void isValid_if_true() {
    String jsonString = "{\"name\": \"John\"}";
    assertTrue(JsonValidator.isValid(jsonString));
}

@Test public void isValid_if_too_many_opened_brackets() {
    String jsonString = "{\"name\": \"John\", {}";
    assertFalse(JsonValidator.isValid(jsonString));
}

@Test public void isValid_if_too_many_closed_brackets() {
    String jsonString = "{\"name\": \"John\", }}";
    assertFalse(JsonValidator.isValid(jsonString));
}

@Test public void isValid_if_too_many_quotes() {
    String jsonString = "{\"name\": \"\"John\"}";
    assertFalse(JsonValidator.isValid(jsonString));
}