static class CustomDeserializer extends JsonDeserializer<OffsetDateTime> {

    private DateTimeFormatter formatter = // create formatter as above

    // deserialize method is the same
}

static class CustomSerializer extends JsonSerializer<OffsetDateTime> {

    private DateTimeFormatter formatter = // create formatter as above

    // serialize method is the same
}