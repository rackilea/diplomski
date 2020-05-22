public final class ZonedDateTimeJsonDeserializerTest {

    private static final TypeToken<ZonedDateTime> zonedDateTimeTypeToken = new TypeToken<ZonedDateTime>() {
    };

    private static final ZonedDateTime expectedZonedDateTime = ZonedDateTime.of(2017, 3, 27, 14, 9, 47, 0, UTC);

    @Test
    public void testDeserializeIndirectlyViaAutomaticTypeAdapterBinding()
            throws IOException {
        final JsonDeserializer<ZonedDateTime> unit = getZonedDateTimeJsonDeserializer();
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, unit)
                .create();
        try ( final JsonReader jsonReader = getPackageResourceJsonReader(ZonedDateTimeJsonDeserializerTest.class, "zoned-date-time.json") ) {
            final ZonedDateTime actualZonedDateTime = gson.fromJson(jsonReader, ZonedDateTime.class);
            assertThat(actualZonedDateTime, is(expectedZonedDateTime));
        }
    }

    @Test
    public void testDeserializeIndirectlyViaManualTypeAdapterBinding()
            throws IOException {
        final JsonDeserializer<ZonedDateTime> unit = getZonedDateTimeJsonDeserializer();
        final Gson gson = new Gson();
        final TypeAdapterFactory typeAdapterFactory = newFactoryWithMatchRawType(zonedDateTimeTypeToken, unit);
        final TypeAdapter<ZonedDateTime> dateTypeAdapter = typeAdapterFactory.create(gson, zonedDateTimeTypeToken);
        try ( final JsonReader jsonReader = getPackageResourceJsonReader(ZonedDateTimeJsonDeserializerTest.class, "zoned-date-time.json") ) {
            final ZonedDateTime actualZonedDateTime = dateTypeAdapter.read(jsonReader);
            assertThat(actualZonedDateTime, is(expectedZonedDateTime));
        }
    }

    @Test
    public void testDeserializeDirectlyWithMockedContext()
            throws IOException {
        final JsonDeserializer<ZonedDateTime> unit = getZonedDateTimeJsonDeserializer();
        final JsonDeserializationContext mockContext = mock(JsonDeserializationContext.class);
        when(mockContext.deserialize(any(JsonElement.class), eq(String.class))).thenAnswer(iom -> {
            final JsonElement jsonElement = (JsonElement) iom.getArguments()[0];
            return jsonElement.getAsJsonPrimitive().getAsString();
        });
        final JsonParser parser = new JsonParser();
        try ( final JsonReader jsonReader = getPackageResourceJsonReader(ZonedDateTimeJsonDeserializerTest.class, "zoned-date-time.json") ) {
            final JsonElement jsonElement = parser.parse(jsonReader);
            final ZonedDateTime actualZonedDateTime = unit.deserialize(jsonElement, ZonedDateTime.class, mockContext);
            assertThat(actualZonedDateTime, is(expectedZonedDateTime));
        }
        verify(mockContext).deserialize(any(JsonPrimitive.class), eq(String.class));
        verifyNoMoreInteractions(mockContext);
    }

}