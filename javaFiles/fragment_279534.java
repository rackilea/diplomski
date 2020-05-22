@Test
public void getDefaultMessage() {
  ResourceBundleMessageSource origSource = <create source>
  MessageResource subSource = <create with same criteria as origSource>
  String key = <some key that is locale-specific>
  assertEquals(origSource.getMessage(key, null, Locale.getDefault()),
               subSource.getMessage(key));
}