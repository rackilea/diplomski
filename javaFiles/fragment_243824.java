@Test
  public void test_unixtime() {
    UnixTimeExtractor extractor = new UnixTimeExtractor() {
      @Override
      InputStream getInputStream(URL url) throws IOException {
        throw new IOException();
      }
    };
    assertThatThrownBy(extractor::unixtime)
      .isInstanceOf(RuntimeException.class)
      .hasMessage("Error while reading from stream");
  }