import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(BrowserManagementListener.class)
public class SampleTestClass {

  @Test
  public void testMethod() {
    BrowserManagementListener.getDriver().get("http://www.google.com");
    throw new RuntimeException("Simulating an error");
  }
}