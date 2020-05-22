public static class ExtendedJsonJacksonMapCodec extends JsonJacksonMapCodec {

    public ExtendedJsonJacksonMapCodec() {
        super(String.class, LocalDateTime.class);
    }

    @Override
    protected void init(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
        super.init(objectMapper);
    }

}