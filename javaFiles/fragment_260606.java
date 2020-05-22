@Test
public void shouldCallClose(final InputStream inputStream) throws Exception {
    new Expectations(){{
        inputStream.close();
    }};

    MyClassUnderTest.closingStreamFunc(inputStream);
}