public class SomeTest extends XMLTestCase {
  @Test
  public void test() {
    String xml1 = ...
    String xml2 = ...

    XMLUnit.setIgnoreWhitespace(true); // ignore whitespace differences

    // can also compare xml Documents, InputSources, Readers, Diffs
    assertXMLEqual(xml1, xml2);  // assertXMLEquals comes from XMLTestCase
  }
}