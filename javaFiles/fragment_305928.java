final class Client {

    private Client() {
    }

    static void consumeResponse(final Reader reader) {
        final List<AssetBookingGsonDto> payload = gson.fromJson(reader, assetBookingListType);
        for ( final AssetBookingGsonDto assetBooking : payload ) {
            System.out.println(assetBooking.assetId + ": " + assetBooking.createdOn);
        }
    }

    // TypeToken.getType() results are constant and can be saved to re-use  
    private static final Type assetBookingListType = new TypeToken<List<AssetBookingGsonDto>>() {
    }.getType();

    // Gson instantiation may take some time, and Gson is thread-safe, so we can re-use it too
    private static final Gson gson = new GsonBuilder()
            // Note that nullSafe() method
            .registerTypeHierarchyAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .create();

    @SuppressWarnings("unused")
    private static final class AssetBookingGsonDto {

        // I prefer not to use getters/setters for DTO data bags
        // * final can be stripped off by Gson -- not a problem
        // * primitive fields cannot be null, but simple 0 and false would cause inlining by javac (0 and false are constaants), so we're cheating javac
        private final int id = Integer.valueOf(0);
        private final int assetId = Integer.valueOf(0);
        private final int userId = Integer.valueOf(0);
        private final LocalDateTime fromDatetime = null;
        private final LocalDateTime toDatetime = null;
        private final boolean status = Boolean.valueOf(false);
        private final LocalDateTime createdOn = null;
        private final LocalDateTime updatedOn = null;
        private final String userName = null;
        private final String userLastName = null;
        private final String userEmail = null;

    }

    private static final class LocalDateTimeAdapter
            extends TypeAdapter<LocalDateTime> {

        @Override
        public void write(final JsonWriter out, final LocalDateTime value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public LocalDateTime read(final JsonReader in)
                throws IOException {
            // Now just decode the string
            return LocalDateTime.parse(in.nextString());
        }

    }

}