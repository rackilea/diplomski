@Test
public void read() {

    String testFileName = "/path/to/test/file/testFile";
    String expected = "my test";
    SearchPhrase searchPhrase = new SearchPhrase();
    String result = searchPhrase.read(testFileName);
    assertEquals(expected, result);

}