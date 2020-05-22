public class LoginPageTest extends IntegrationTest {

private HtmlUnitDriver driver;

@Before
public void setup() throws MalformedURLException, UnknownHostException{
    driver = new HtmlUnitDriver(true);
    driver.get(System.getProperty("login.url"));
}

@Test
public void testAuthenticationFailureWhenProvidingBadCredentials(){
    driver.findElement(By.id("username")).sendKeys("fakeuser");
    driver.findElement(By.id("password")).sendKeys("fakepassword");     
    driver.findElement(By.id("login")).click();

    assertTrue(driver.getCurrentUrl().endsWith("failed"));
}

@Test
public void testAuthenticationSuccessWhenProvidingCorrectCredentials(){
    driver.findElement(By.id("username")).sendKeys("validuser");
    driver.findElement(By.id("password")).sendKeys("validpassword");
    driver.findElement(By.id("login")).click();

    assertTrue(driver.getCurrentUrl().endsWith("/<name_of_webapp>/"));
}

}