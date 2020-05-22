final class Server {

    private Server() {
    }

    static InputStream produceResponse()
            throws IOException {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        objectMapper.writeValue(byteArrayOutputStream, payload);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    private static final LocalDateTime date = new LocalDateTime(2017, 4, 16, 17, 15);

    private static final List<AssetBookingJacksonDto> payload = ImmutableList.of(
            new AssetBookingJacksonDto(1, 10, 100, date, date, true, date, date, "foo", "bar", "foo.bar@email")
    );

    private static final ObjectMapper objectMapper = createObjectMapper();

    private static ObjectMapper createObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        // Here we just define that we don't need getters and will use fields for brevity   
        return objectMapper
                .setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                        .withFieldVisibility(ANY)
                        .withGetterVisibility(NONE)
                        .withSetterVisibility(NONE)
                        .withCreatorVisibility(NONE)
                )
                // Here is where LocalDateTime serialization strategy is registered
                .registerModule(new SimpleModule()
                        .addSerializer(LocalDateTime.class, new LocalDateTimeJsonSerializer())
                );
    }

    @SuppressWarnings("unused")
    private static final class AssetBookingJacksonDto {

        private final int id;
        private final int assetId;
        private final int userId;
        private final LocalDateTime fromDatetime;
        private final LocalDateTime toDatetime;
        private final boolean status;
        private final LocalDateTime createdOn;
        private final LocalDateTime updatedOn;
        private final String userName;
        private final String userLastName;
        private final String userEmail;

        private AssetBookingJacksonDto(final int id, final int assetId, final int userId, final LocalDateTime fromDatetime, final LocalDateTime toDatetime,
                final boolean status, final LocalDateTime createdOn, final LocalDateTime updatedOn, final String userName, final String userLastName,
                final String userEmail) {
            this.id = id;
            this.assetId = assetId;
            this.userId = userId;
            this.fromDatetime = fromDatetime;
            this.toDatetime = toDatetime;
            this.status = status;
            this.createdOn = createdOn;
            this.updatedOn = updatedOn;
            this.userName = userName;
            this.userLastName = userLastName;
            this.userEmail = userEmail;
        }

    }

    private static final class LocalDateTimeJsonSerializer
            extends JsonSerializer<LocalDateTime> {

        @Override
        public void serialize(final LocalDateTime localDateTime, final JsonGenerator generator, final SerializerProvider serializers)
                throws IOException {
            // Just encode it's as a simple string -- this is all you need
            generator.writeString(localDateTime.toString());
        }

    }

}