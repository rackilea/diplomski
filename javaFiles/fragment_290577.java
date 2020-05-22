@Test
public void test() throws UnsupportedEncodingException {
    String[] samples = {
            "hello",
            "all your base now belongs to us, welcome our machine overlords"
    };
    for (String sample : samples) {
        assertEquals(sample, fromHex(toHex(sample)));
    }
}