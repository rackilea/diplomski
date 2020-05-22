SimpleDateFormat[] formats = new SimpleDateFormat[] {
    new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
    // Others formats go here
};

// ...

return new GsonBuilder()
    .registerTypeAdapter(Date.class, new TypeAdapter<Date>() {

        @Override
        public Date read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return null;
            }
            String dateAsString = reader.nextString();
            for (SimpleDateFormat format : formats) {
                try {
                    return format.parse(dateAsString);
                } catch (ParseException e) {}  // Ignore that, try next format
            }
            // No matching format found!
            return null;
        }
    })
    .create();