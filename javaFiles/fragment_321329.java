public final class ZonedDateTimeTypeAdapterTest {

    private static final ZonedDateTime expectedZonedDateTime = ZonedDateTime.of(2017, 3, 27, 14, 9, 47, 0, UTC);

    @Test(expected = UnsupportedOperationException.class)
    public void testWrite() {
        final TypeAdapter<ZonedDateTime> unit = getZonedDateTimeTypeAdapter();
        unit.toJsonTree(expectedZonedDateTime);
    }

    @Test
    public void testRead()
            throws IOException {
        final TypeAdapter<ZonedDateTime> unit = getZonedDateTimeTypeAdapter();
        try ( final Reader reader = getPackageResourceReader(ZonedDateTimeTypeAdapterTest.class, "zoned-date-time.json") ) {
            final ZonedDateTime actualZonedDateTime = unit.fromJson(reader);
            assertThat(actualZonedDateTime, is(expectedZonedDateTime));
        }
    }

}