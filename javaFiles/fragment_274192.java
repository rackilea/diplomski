static class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

        private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTimeDeserializer(String datePattern) {
            this.formatter = DateTimeFormatter.ofPattern(datePattern);
        }

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), formatter);
        }