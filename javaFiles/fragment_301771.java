public final class GsonStuffTest {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(getValueTypeAdapterFactory())
            .registerTypeAdapterFactory(getPostValueTypeAdapterFactory())
            .create();

    @Test
    public void testIsValue() {
        final DataBag dataBag = parseDataBag("{\"integer\":100,\"string\":\"foo\"}");
        assertThat(dataBag.integer.isValue(), is(true));
        assertThat(dataBag.integer.getValue(), is(100));
        assertThat(dataBag.string.isValue(), is(true));
        assertThat(dataBag.string.getValue(), is("foo"));
    }

    @Test
    public void testIsNoValue() {
        final DataBag dataBag = parseDataBag("{\"integer\":null,\"string\":null}");
        assertThat(dataBag.integer.isNoValue(), is(true));
        assertThat(dataBag.string.isNoValue(), is(true));
    }

    @Test
    public void testIsUndefined() {
        final DataBag dataBag = parseDataBag("{}");
        assertThat(dataBag.integer.isUndefined(), is(true));
        assertThat(dataBag.string.isUndefined(), is(true));
    }

    private static DataBag parseDataBag(final String json) {
        return gson.fromJson(json, DataBag.class);
    }

}