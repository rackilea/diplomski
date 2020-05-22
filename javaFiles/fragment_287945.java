import com.thoughtworks.selenium.SeleneseTestCase;

public class TestCase extends SeleneseTestCase {

  public void setUp() throws Exception {
    setUp("http://www.google.com/", "*firefox");
  }

  public void testAuto() throws Exception {
    selenium.open("/");
    selenium.type("q", "selenium rc");
    selenium.click("btnG");
    selenium.waitForPageToLoad("30000");
    assertTrue(selenium.isTextPresent("Advanced search"));
  }
}