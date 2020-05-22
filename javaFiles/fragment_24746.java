@Test
public static void testCredentials() {
    WebDriver driver = new FirefoxDriver();
    driver.get("http://mail.google.com/");
    EnterValidCredentials enterValidCredentials = new EnterValidCredentials(); // Or create a mock if necessary
    // Set values if necessary
    int returnValue = enterValidCredentials.clickLoginButton();
    assertEquals(returnValue, 1);
}