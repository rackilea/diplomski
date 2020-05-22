@Test
public void test() throws Exception {
  setUp("http://www.google.com/", "*chrome");
  selenium.open("/");
  selenium.type("q", "selenium rc");
  selenium.click("btnG");
  selenium.waitForPageToLoad("30000");
  assertTrue(selenium.isTextPresent("Advanced search"));
}