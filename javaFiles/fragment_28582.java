@Test public void test() throws Exception {
    btye[] expected = <expected data>;
    ByteArrayOutputStream actualStream = new ByteArrayOutputStream();
    new DefaultComplexDataSerializer().write(actualStream, data);
    byte[] actualData = actualStream.toByteArray();
    // compare expected and actualData
}