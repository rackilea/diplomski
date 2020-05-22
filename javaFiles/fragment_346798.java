@Before public void setup() throws IOException {
    final URL mockUrl = this.getClass().getResource("/foo/bar.txt");
    Network.UrlOpener opener = Mockito.mock(Network.UrlOpener.class);
    Answer<InputStream> substituteUrl = new Answer<InputStream>() {
        public InputStream answer(InvocationOnMock invocation) throws Throwable {
            return mockUrl.openStream();
        }
    };
    Mockito.when(opener.open(Mockito.any(URL.class))).then(substituteUrl);
    Network.setUrlOpener(opener);
}

@Test public void testSomething() throws IOException {
    SomeType something = new SomeType();
    something.processData(new URL("http://example.com"));
}