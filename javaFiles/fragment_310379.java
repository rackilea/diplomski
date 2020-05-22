class YourClass {
  public int method(File file) {
    // do everything here, which is why it requires a mock
  }   
}   

class YourRefactoredClass {
  public int method(File file) {
    return methodForTest(file.getName(), file.isFile(),
        file.isAbsolute(), new FileReader(file));
  }   

  /** For testing only. */
  int methodForTest(
      String name, boolean isFile, boolean isAbsolute, Reader fileContents) {
    // actually do the calculation here
  }   
}   

class YourTest {
  @Test public int methodShouldParseBadHtml() {
    YourRefactoredClass yrc = new YourRefactoredClass();
    assertEquals(42, yrc.methodForTest(
        "bad.html", true, false, new StringReader(badHTMLText));
  }   
}