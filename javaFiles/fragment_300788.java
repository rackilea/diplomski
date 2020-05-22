public class Tests_Steps {

  WebDriver driver = null;

  @Given("^User is on the Home Page$")
  public void user_is_on_the_Home_Page() throws Throwable {
    driver=new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.get("http://www.gmail.com/login");
  }

  ------------
  ------------
}